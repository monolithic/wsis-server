var searchText = document.getElementById('searchText').value;
var category = {
    "0": {
        name: "根节点",
        icon: "img/1.png"
    },
    "1": {
        name: "分公司",
        icon: "img/2.png"
    },
    "2": {
        name: "股东代表",
        icon: "img/3.png"
    },
    "3": {
        name: "法人代表",
        icon: "img/4.png"
    }
};
var tooltip = d3.select("body")
    .append("div")
    .attr('class', 'tooltip')
    .attr('width', 200)
    .attr('height', 50)
    .style("position", "absolute")
    .style("z-index", "10")
    .style("visibility", "hidden")
// .append("div")
// .attr('class','tipcontent')
    .text("a simple tooltip");
var width = 1000,
    height = 600;
var margin = {
    top: 20,
    right: 20,
    bottom: 30,
    left: 50
};

var svg = d3.select("#content").append("svg")
    .attr("width", width)
    .attr("height", height);

var node = svg.selectAll(".node"),
    link = svg.selectAll(".link");
var nodes = [],
    links = [];
var force = d3.layout.force().linkDistance(150).charge(-100)
    .size([width, height]).on("tick", function (e) {
        link.attr("x1", function (d) {
            return d.source.x;
        })
            .attr("y1", function (d) {
                return d.source.y;
            })
            .attr("x2", function (d) {
                return d.target.x;
            })
            .attr("y2", function (d) {
                return d.target.y;
            });

        node.attr("transform", function (d) {
            if (d.index == 0) {
                damper = 0.1;
                d.x = d.x + (width / 2 - d.x) * (damper + 0.71) * e.alpha;
                d.y = d.y + (height / 2 - d.y) * (damper + 0.71) * e.alpha;
            }
            if (d.start === true) {
                d.x = width / 2;
                d.y = height / 2 - 60;
                d.start = false;
            }
            r = d.name.length;
            return "translate(" + d.x + "," + d.y + ")";
        });
    });

function updateAll() {
    $("#content").empty();
    svg = d3.select("#content").append("svg")
        .attr("width", width)
        .attr("height", height);
    node = svg.selectAll(".node"),
        link = svg.selectAll(".link");

    link = link.data(links);
    link.enter().append("line")
        .attr("class", "link");
    link.exit().remove();
    node = node.data(nodes, function (d) {
        return d.name + d.category; //用于判别唯一性，如果有id，就直接return d.id
    });
    var nodeEnter = node.enter().append("g")
        .attr("class", "node")
        .call(force.drag);

    nodeEnter.append("image")
        .attr("xlink:href", function (d, i) {
            return category[d.category].icon;
        })
        .attr("x", -34)
        .attr("y", -34)
        .attr("width", 68)
        .attr("height", 68);

    nodeEnter.append("text")
        .attr("dx", 0)
        .attr("dy", "50")
        .style("fill", "#fff")
        .style("text-anchor", "middle")
        .text(function (d) {
            return d.name;
        });
    nodeEnter.on("mouseover", function () {
        tooltip.text(category[this.__data__.category].name + ":" + this.__data__.name); //显示内容
        return tooltip.style("visibility", "visible");
    })
        .on("mousemove", function () {
            return tooltip.style("top", (d3.event.pageY - 10) + "px")
                .style("left", (d3.event.pageX + 10) + "px");
        })
        .on("mouseout", function () {
            return tooltip.style("visibility", "hidden");
        })
        .on("click", function (d) {
            //search(d.name);
            clickNode(d.name);
        });
    node.exit().remove();
    force.nodes(nodes).links(links).start();
}

function search(content) {
    d3.json("graph2.json", function (error, json) {
        if (json[content]) {
            links = json[content].links;
            nodes = json[content].nodes;
            updateAll();
            //add();
        } else {
            //TODO 没找到节点对应信息的
        }
    });
}
function clickNode(content) {
    d3.json("graph2.json", function (error, json) {
        if (json[content]) {
            //links = json[content].links;
            //nodes = json[content].nodes;

        } else {
            //TODO 没找到节点对应信息的
        }
    });
}
function add() {

}
$(document).ready(function () {

    $(".select_box").click(function (event) {
        event.stopPropagation();
        $(this).find(".option").toggle();
        $(this).parent().siblings().find(".option").hide();
    });
    $(document).click(function (event) {
        var eo = $(event.target);
        if ($(".select_box").is(":visible") && eo.attr("class") != "option" && !eo.parent(".option").length) $('.option').hide();
    });
    /*赋值给文本框*/
    $(".option a").click(function () {
        var value = $(this).text();
        $(this).parent().siblings(".select_txt").text(value)
            .siblings(".select_value").val(value);
        //$(this).parent() 
    })

    $("#btnSearch").click(function () {
        search($("#searchText").val());
    });

});
