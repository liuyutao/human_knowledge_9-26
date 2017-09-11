/**
 * Created by LiuYuTao on 2017/8/30.
 */
$(function () {
    var server = "http://192.168.1.142:18080";
    var config = {
        api: {
            getPicList: server + "/services/knowledge/comm/data/materiel/getMapList",
            save: server + "/services/knowledge/customer/answer/create",
            getUser:server + "/services/knowledge/customer/baseinfo/getMapList"
        },
        title: "人体肌肉名词测验",
        frontMap: {
            leftNum: 13,
            img: {
                src: "muscle-front-no-text.png",
                width: 625,
                height: 758
            },
            positions: [{
                index: 1,
                title: "枕额肌额腹",
                x: 59,
                y: 46
            }, {
                index: 2,
                title: "颞顶肌",
                x: 94,
                y: 64
            }, {
                index: 3,
                title: "颞肌",
                x: 112,
                y: 79
            }, {
                index: 4,
                title: "胸锁乳突肌",
                x: 59,
                y: 117
            }, {
                index: 5,
                title: "腹直肌",
                x: 95,
                y: 175
            }, {
                index: 6,
                title: "腹外斜肌",
                x: 77,
                y: 203
            }, {
                index: 7,
                title: "白线",
                x: 113,
                y: 308
            }, {
                index: 8,
                title: "屈肌支持带",
                x: 15,
                y: 360
            }, {
                index: 9,
                title: "髂胫束",
                x: 120,
                y: 449
            }, {
                index: 10,
                title: "髌骨",
                x: 139,
                y: 493
            }, {
                index: 11,
                title: "胫骨",
                x: 139,
                y: 538
            }, {
                index: 12,
                title: "伸肌上支持带",
                x: 69,
                y: 625
            }, {
                index: 13,
                title: "伸肌下支持带",
                x: 69,
                y: 641
            }, {
                index: 14,
                title: "斜方肌",
                x: 470,
                y: 64
            }, {
                index: 15,
                title: "锁骨",
                x: 377,
                y: 89
            }, {
                index: 16,
                title: "胸骨",
                x: 376,
                y: 112
            }, {
                index: 17,
                title: "三角肌",
                x: 470,
                y: 96
            }, {
                index: 18,
                title: "胸大肌",
                x: 470,
                y: 119
            }, {
                index: 19,
                title: "背阔肌",
                x: 470,
                y: 139
            }, {
                index: 20,
                title: "前锯肌",
                x: 470,
                y: 154
            }, {
                index: 21,
                title: "肱二头肌",
                x: 470,
                y: 172
            }, {
                index: 22,
                title: "肱三头肌",
                x: 470,
                y: 195
            }, {
                index: 23,
                title: "肱肌",
                x: 470,
                y: 212
            }, {
                index: 24,
                title: "旋前圆肌",
                x: 470,
                y: 235
            }, {
                index: 25,
                title: "肱桡肌",
                x: 470,
                y: 252
            }, {
                index: 26,
                title: "桡侧腕长伸肌",
                x: 470,
                y: 272
            }, {
                index: 27,
                title: "桡侧腕短伸肌",
                x: 470,
                y: 287
            }, {
                index: 28,
                title: "掌长肌",
                x: 470,
                y: 314
            }, {
                index: 29,
                title: "桡侧腕屈肌",
                x: 470,
                y: 332
            }, {
                index: 30,
                title: "指浅屈肌",
                x: 470,
                y: 350
            }, {
                index: 31,
                title: "尺侧腕屈肌",
                x: 470,
                y: 369
            }, {
                index: 32,
                title: "臀中肌",
                x: 470,
                y: 391
            }, {
                index: 34,
                title: "阔筋膜张肌",
                x: 470,
                y: 411
            }, {
                index: 35,
                title: "髂腰肌",
                x: 470,
                y: 431
            }, {
                index: 36,
                title: "耻骨肌",
                x: 470,
                y: 452
            }, {
                index: 37,
                title: "长收肌",
                x: 470,
                y: 471
            }, {
                index: 38,
                title: "股薄肌",
                x: 470,
                y: 492
            }, {
                index: 39,
                title: "缝匠肌",
                x: 470,
                y: 511
            }, {
                index: 40,
                title: "股直肌",
                x: 470,
                y: 535
            }, {
                index: 41,
                title: "股外侧肌",
                x: 470,
                y: 552
            }, {
                index: 42,
                title: "股内侧肌",
                x: 470,
                y: 574
            }, {
                index: 43,
                title: "腓骨长肌",
                x: 470,
                y: 596
            }, {
                index: 44,
                title: "腓肠肌",
                x: 470,
                y: 615
            }, {
                index: 45,
                title: "胫骨前肌",
                x: 470,
                y: 634
            }, {
                index: 46,
                title: "比目鱼肌",
                x: 470,
                y: 648
            }, {
                index: 47,
                title: "趾长伸肌",
                x: 470,
                y: 667
            }, {
                index: 48,
                title: "外踝",
                x: 470,
                y: 699
            }, {
                index: 49,
                title: "内踝",
                x: 470,
                y: 720
            }]
        },
        backMap: {
            leftNum: 4,
            img: {
                src: "muscle-front-no-text.png",
                width: 625,
                height: 758
            },
            positions: [{
                index: 1,
                title: "枕额肌额腹",
                x: 23,
                y: 63
            }, {
                index: 2,
                title: "胸锁乳突肌",
                x: 26,
                y: 90
            }, {
                index: 3,
                title: "腹外斜肌",
                x: 39,
                y: 142
            }, {
                index: 4,
                title: "髂胫束",
                x: 58,
                y: 457
            }, {
                index: 5,
                title: "斜方肌",
                x: 442,
                y: 92
            }, {
                index: 6,
                title: "三角肌",
                x: 442,
                y: 115
            }, {
                index: 7,
                title: "冈下肌",
                x: 442,
                y: 141
            }, {
                index: 8,
                title: "小圆肌",
                x: 442,
                y: 159
            }, {
                index: 9,
                title: "大圆肌",
                x: 442,
                y: 181
            }, {
                index: 10,
                title: "菱形肌",
                x: 442,
                y: 195
            }, {
                index: 11,
                title: "肱三头肌(长头)",
                x: 442,
                y: 213
            }, {
                index: 12,
                title: "肱三头肌(短头)",
                x: 442,
                y: 235
            }, {
                index: 13,
                title: "背阔肌",
                x: 442,
                y: 253
            }, {
                index: 14,
                title: "肱桡肌",
                x: 442,
                y: 270
            }, {
                index: 15,
                title: "桡侧腕长伸肌",
                x: 442,
                y: 288
            }, {
                index: 16,
                title: "肘肌",
                x: 442,
                y: 304
            }, {
                index: 17,
                title: "尺侧腕屈肌",
                x: 442,
                y: 322
            }, {
                index: 18,
                title: "指伸肌",
                x: 442,
                y: 341
            }, {
                index: 19,
                title: "尺侧腕屈肌",
                x: 442,
                y: 358
            }, {
                index: 20,
                title: "阔筋膜张肌",
                x: 442,
                y: 378
            }, {
                index: 21,
                title: "臀中肌",
                x: 442,
                y: 397
            }, {
                index: 22,
                title: "臀大肌",
                x: 442,
                y: 415
            }, {
                index: 23,
                title: "大收肌",
                x: 442,
                y: 431
            }, {
                index: 24,
                title: "半腱肌",
                x: 442,
                y: 448
            }, {
                index: 25,
                title: "半膜肌",
                x: 442,
                y: 464
            }, {
                index: 26,
                title: "股薄肌",
                x: 442,
                y: 484
            }, {
                index: 27,
                title: "股二头肌",
                x: 442,
                y: 502
            }, {
                index: 28,
                title: "缝匠肌",
                x: 442,
                y: 523
            }, {
                index: 29,
                title: "跖肌",
                x: 442,
                y: 542
            }, {
                index: 30,
                title: "腓肠肌",
                x: 442,
                y: 558
            }, {
                index: 31,
                title: "比目鱼肌",
                x: 442,
                y: 585
            }, {
                index: 32,
                title: "跟腱",
                x: 442,
                y: 675
            }, {
                index: 33,
                title: "跟骨",
                x: 442,
                y: 699
            }]
        },
        boneMap:{
            leftNum: 4,
            img: {
                src: "muscle-front-no-text.png",
                width: 625,
                height: 758
            },
            positions: [{
                index: 1,
                title: "枕额肌额腹",
                x: 23,
                y: 63
            }, {
                index: 2,
                title: "胸锁乳突肌",
                x: 26,
                y: 90
            }, {
                index: 3,
                title: "腹外斜肌",
                x: 39,
                y: 142
            }, {
                index: 4,
                title: "髂胫束",
                x: 58,
                y: 457
            }, {
                index: 5,
                title: "斜方肌",
                x: 442,
                y: 92
            }, {
                index: 6,
                title: "三角肌",
                x: 442,
                y: 115
            }, {
                index: 7,
                title: "冈下肌",
                x: 442,
                y: 141
            }, {
                index: 8,
                title: "小圆肌",
                x: 442,
                y: 159
            }, {
                index: 9,
                title: "大圆肌",
                x: 442,
                y: 181
            }, {
                index: 10,
                title: "菱形肌",
                x: 442,
                y: 195
            }, {
                index: 11,
                title: "肱三头肌(长头)",
                x: 442,
                y: 213
            }, {
                index: 12,
                title: "肱三头肌(短头)",
                x: 442,
                y: 235
            }, {
                index: 13,
                title: "背阔肌",
                x: 442,
                y: 253
            }, {
                index: 14,
                title: "肱桡肌",
                x: 442,
                y: 270
            }, {
                index: 15,
                title: "桡侧腕长伸肌",
                x: 442,
                y: 288
            }, {
                index: 16,
                title: "肘肌",
                x: 442,
                y: 304
            }, {
                index: 17,
                title: "尺侧腕屈肌",
                x: 442,
                y: 322
            }, {
                index: 18,
                title: "指伸肌",
                x: 442,
                y: 341
            }, {
                index: 19,
                title: "尺侧腕屈肌",
                x: 442,
                y: 358
            }, {
                index: 20,
                title: "阔筋膜张肌",
                x: 442,
                y: 378
            }, {
                index: 21,
                title: "臀中肌",
                x: 442,
                y: 397
            }, {
                index: 22,
                title: "臀大肌",
                x: 442,
                y: 415
            }, {
                index: 23,
                title: "大收肌",
                x: 442,
                y: 431
            }, {
                index: 24,
                title: "半腱肌",
                x: 442,
                y: 448
            }, {
                index: 25,
                title: "半膜肌",
                x: 442,
                y: 464
            }, {
                index: 26,
                title: "股薄肌",
                x: 442,
                y: 484
            }, {
                index: 27,
                title: "股二头肌",
                x: 442,
                y: 502
            }, {
                index: 28,
                title: "缝匠肌",
                x: 442,
                y: 523
            }, {
                index: 29,
                title: "跖肌",
                x: 442,
                y: 542
            }, {
                index: 30,
                title: "腓肠肌",
                x: 442,
                y: 558
            }, {
                index: 31,
                title: "比目鱼肌",
                x: 442,
                y: 585
            }, {
                index: 32,
                title: "跟腱",
                x: 442,
                y: 675
            }, {
                index: 33,
                title: "跟骨",
                x: 442,
                y: 699
            }]
        },
        questInputNum: 20
    };

    var controller = {
        init: function () {
            var t = this;
            t.showAll();// TODO: delete this
            $("title").text(config.title);
            $("#title").text(config.title);
            t.bindStartButton();
            t.initUser();
        },
        initUser: function () {
            debugger;
            $.ajax({
                url: config.api.getUser,
                type:"GET",
                success: function (data) {

                }
            })
        },
        bindStartButton: function () {
            var t = this;

            $("#startAnswer").on("click", function () {
                t.picIndex = 1;
                t.startAnswer();
                $(this).hide();
                $("#next").show();
                $("#submit").show();
                t.bindSubmit();
                t.bindNext();
                t.bindPrev();
            });
        },
        bindPrev: function () {
            var t = this;
            $("#prev").on("click", function () {
                t.picIndex--;
                if (t.picIndex == 1) {
                    $("#prev").show();
                }
            });
        },
        bindNext: function () {
            var t = this;

            $("#next").on("click", function () {
                t.picIndex++;
                if (t.picIndex > 1) {
                    $("#prev").show();
                }
                if (t.picIndex == 3) {
                    $("#prev").show();
                }
            });
        },
        bindSubmit: function () {
            $("#submit").on("click", function (e) {
                var allInputs = $(".answers input");

                var rst = [];
                allInputs.each(function (index, item) {
                    rst.push({input: $(item).val(), id: $(item).attr("index")});
                });

                console.log(rst);
            })
        },
        startAnswer: function () {
            var t = this;
            var randomPositions = t.getRandomPosition();
            t.showSelectedPosition(randomPositions);
            t.createInput(randomPositions);
        },
        getRandomPosition: function () {
            var result = {};

            function getRandomInArray(arr, num) {
                var l = arr.length;
                var rst = [];
                var i = 0;
                var tempArr = [];
                while (i < num) {
                    var obj = {};
                    var index = Math.floor(Math.random() * l);
                    if (tempArr.indexOf(index) < 0) {
                        obj = $.extend(obj, arr[index]);
                        tempArr.push(index);
                        rst.push(obj);
                        i++;
                    }
                }
                return rst;
            }

            result.left = getRandomInArray(config.frontMap.positions, config.questInputNum);
            result.right = getRandomInArray(config.backMap.positions, config.questInputNum);

            function sort(a, b) {
                if (a.index < b.index) {
                    return -1
                } else if (a == b) {
                    return 0;
                } else {
                    return 1;
                }
            }

            result.left = result.left.sort(sort);
            result.right = result.right.sort(sort);

            return result;
        },
        showSelectedPosition: function (positions) {
            var t = this;
            t.clear();
            function show(el, arr, type) {
                el.selectAll("text")
                    .data(arr)
                    .enter()
                    .append("text")
                    .attr("class", "text")
                    .attr("x", function (d, i) {
                        var compareIndex;
                        if (type == "left") {
                            compareIndex = config.frontMap.leftNum;
                        } else {
                            compareIndex = config.backMap.leftNum;
                        }
                        if (d.index <= compareIndex) {
                            return d.x + 30 + d.title.length * 20;
                        } else {
                            return d.x + 50;
                        }

                    })
                    .attr("y", function (d, i) {
                        return d.y + 23
                    })
                    .text(function (d, i) {
                        return i;
                    })
            }

            show(d3.select("#leftSVG"), positions.left, "left");
            show(d3.select("#rightSVG"), positions.right, "right");
        },
        clear: function () {
            d3.selectAll("text.text").remove();
        },
        createInput: function (randompositions) {
            var t = this;

            function createInput(el, arr) {
                var ul = $(el).find(".row");
                for (var i = 0, l = arr.length; i < l; i++) {
                    ul.append("<div class='col-lg-1 text-align-right index'>" + i + "</div>" +
                        "<div class='col-lg-3 '><Input index='" + arr[i].index + "' questIndex='" + i + "'  /></div>");
                }
            }

            createInput($("#answerLeft"), randompositions.left);
            createInput($("#answerRight"), randompositions.right);
        },
        showAll: function () {
            var t = this;

            function show(el, arr) {
                el.selectAll("text")
                    .data(arr)
                    .enter()
                    .append("text")
                    .attr("class", "text")
                    .attr("x", function (d) {
                        return d.x + 50
                    })
                    .attr("y", function (d) {
                        return d.y + 23
                    })
                    .text(function (d, i) {
                        return d.title;
                    })
            }

            show(d3.select("#leftSVG"), config.frontMap.positions);
            show(d3.select("#rightSVG"), config.backMap.positions);
        }
    };

    var timer = {};

    controller.init();
});