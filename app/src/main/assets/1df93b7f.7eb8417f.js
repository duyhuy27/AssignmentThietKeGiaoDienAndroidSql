"use strict";
(self.webpackChunkmoney_lover_landing_page = self.webpackChunkmoney_lover_landing_page || []).push([[3237], {
    3485: function(e, t, n) {
        var a = n(1516);
        a.ZP.initialize("UA-39420218-18"),
        t.Z = a.ZP
    },
    5352: function(e, t, n) {
        n.r(t),
        n.d(t, {
            default: function() {
                return S
            }
        });
        var a = n(7294)
          , l = n(5878)
          , r = n(6700)
          , i = "mainPageWrapper_z5dv"
          , o = n(4996)
          , c = n(6066)
          , s = n(4973)
          , m = function() {
            var e = {
                arrows: !1,
                dots: !1,
                slidesToShow: 3,
                slidesToScroll: 3,
                centerMode: !0,
                responsive: [{
                    breakpoint: 912,
                    settings: {
                        arrows: !1,
                        dots: !1,
                        infinite: !0,
                        autoplay: !0,
                        speed: 500,
                        slidesToShow: 2,
                        slidesToScroll: 2,
                        centerMode: !1
                    }
                }, {
                    breakpoint: 480,
                    settings: {
                        arrows: !1,
                        dots: !1,
                        infinite: !0,
                        autoplay: !0,
                        speed: 500,
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        centerMode: !1
                    }
                }]
            };
            return a.createElement("section", {
                className: "container mt-14 lg:mt-44"
            }, a.createElement("style", null, d), a.createElement("h2", {
                className: "text-dark-tiny tracking-tight text-26 lg:text-40 lg:leading-52 font-medium leading-32 text-center"
            }, a.createElement(s.Z, {
                id: "reviews"
            }, "See what others have to say")), a.createElement("p", {
                className: "flex justify-center mt-4 lg:mb-8"
            }, a.createElement("img", {
                src: (0,
                o.Z)("/img/Stars.svg"),
                alt: ""
            }), a.createElement("p", {
                className: "pl-1"
            }, a.createElement("span", {
                className: "font-bold pr-1"
            }, "4.9"), a.createElement("span", {
                style: {
                    color: "#7E7E7E"
                },
                className: "text-14"
            }, a.createElement(s.Z, {
                id: "reviews.star"
            }, "Based on user reviews")))), a.createElement(c.Z, e, a.createElement("div", {
                className: "review-slide lg:h-screen grid grid-rows-6 px-4 py-6 lg:p-6 text-center"
            }, a.createElement("p", {
                className: "text-dark-brown lg:h-screen"
            }, a.createElement(s.Z, {
                id: "reviews.one"
            }, "Perfect app. My husband and I use it to track all our expenses and income. We generate our household accounts and budget using this fab app. Furthermore, the developers are hands-on and extremely helpful. Do not look any further. Get this app now!.")), a.createElement("p", {
                className: "pt-4 font-bold leading-20"
            }, "Lorna Mifsud Cachia")), a.createElement("div", {
                className: "review-slide lg:h-screen grid grid-rows-6 px-4 py-6 lg:p-6 text-center"
            }, a.createElement("p", {
                className: "text-dark-brown lg:h-screen"
            }, a.createElement(s.Z, {
                id: "reviews.two"
            }, "This will keep you organized and in control, of money you do have and money you will have. This application is easy to use and will help you keep track of every dollar.")), a.createElement("p", {
                className: "pt-4 font-bold leading-20"
            }, "Minh & Tam")), a.createElement("div", {
                className: "review-slide lg:h-screen grid grid-rows-6 px-4 py-6 lg:p-6 text-center"
            }, a.createElement("p", {
                className: "text-dark-brown lg:h-screen"
            }, a.createElement(s.Z, {
                id: "reviews.three"
            }, "A simple, accessible app that allows you to budget across weeks, months and years. The neat financial calendar lets you set up alerts and keep tabs on all transactions. Plus, it works with all currencies.")), a.createElement("p", {
                className: "pt-4 font-bold leading-20"
            }, "Jeveny Johnson"))))
        }
          , d = " \n  @media screen and (min-width: 1024px) {\n      .slick-slide > div {\n        margin: 0 15px;\n      }\n  }\n  .review-slide p {\n    max-height: 240px;\n  }\n  .review-slide {\n    max-width: 370px;\n    max-height: 324px;\n    margin-top: 24px;\n    border: 1px solid #f0f0f0 !important;\n    border-radius: 8px;\n    box-sizing: border-box;\n  }\n"
          , g = [{
            image: "/img/introfeature/1.svg",
            description: (0,
            s.I)({
                id: "intros.secured",
                message: "100% Secured data"
            })
        }, {
            image: "/img/introfeature/2.svg",
            description: (0,
            s.I)({
                id: "intros.users",
                message: "1 Millions+ users"
            })
        }, {
            image: "/img/introfeature/3.svg",
            description: (0,
            s.I)({
                id: "intros.review",
                message: "100K+ 5-star Reviews"
            })
        }, {
            image: "/img/introfeature/4.svg",
            description: (0,
            s.I)({
                id: "intros.recommend",
                message: "App of the day"
            })
        }]
          , p = function(e) {
            var t = e.children;
            return a.createElement("figure", {
                className: "grid grid-cols-2 gap-x-2 gap-y-4 lg:gap-x-6 lg:grid-cols-4"
            }, t)
        }
          , u = function() {
            return a.createElement("section", {
                className: "container bg-monochrome-white mt-14 lg:mt-0"
            }, a.createElement(p, null, g && g.map((function(e) {
                var t = e.image
                  , n = e.description;
                return a.createElement("div", {
                    key: Math.random(),
                    className: "flex p-4 lg:px-2 lg:py-6 gap-y-2 lg:gap-y-4 rounded-lg bg-monochrome-light flex-col items-center"
                }, a.createElement("img", {
                    src: (0,
                    o.Z)(t),
                    alt: ""
                }), a.createElement("p", {
                    className: "font-bold text-dark-tiny leading-24 text-center lg:text-20 lg:leading-28"
                }, n))
            }
            ))))
        }
          , f = n(6010)
          , h = "figure_vZXh"
          , v = "imgWrapper_H04T"
          , x = function(e) {
            var t = e.children;
            return a.createElement("figure", {
                className: (0,
                f.Z)(h, "grid grid-cols-8 md:grid-cols-12 items-center justify-items-start gap-y-4 md:gap-x-12 md:gap-y-0 pb-14 md:py-0")
            }, t)
        }
          , b = function() {
            return a.createElement("section", {
                className: "container mt-14 md:mt-44 bg-monochrome-white"
            }, a.createElement(x, null, a.createElement("figcaption", {
                className: "col-span-full md:col-span-5 md:col-start-7 md:place-self-center md:self-center md:order-2"
            }, a.createElement("h3", {
                className: "text-26 tracking-tight font-medium md:text-26 lg:text-40 md:leading-52 leading-32 text-dark-tiny"
            }, a.createElement(s.Z, {
                id: "details.one"
            }, "Simple money tracker")), a.createElement("p", {
                className: "mt-2 text-monochrome-shade"
            }, a.createElement(s.Z, {
                id: "details.one.desc"
            }, "It takes seconds to record daily transactions. Put them into clear and visualized categories such as Expense: Food, Shopping or Income: Salary, Gift."))), a.createElement("div", {
                className: "md:order-1 col-span-full md:col-span-5 md:col-start-2 md:place-self-center md:self-center"
            }, a.createElement("div", {
                className: (0,
                f.Z)(v, "md:w-11/12 mx-auto")
            }, a.createElement("img", {
                src: (0,
                o.Z)("img/details/Transaction@4x.png"),
                alt: "coverage"
            })))), a.createElement(x, null, a.createElement("figcaption", {
                className: "col-span-full md:col-span-5 md:col-start-2 md:place-self-center md:self-center"
            }, a.createElement("h3", {
                className: "text-26 tracking-tight font-medium md:text-26 lg:text-40 md:leading-52 leading-32 text-dark-tiny"
            }, a.createElement(s.Z, {
                id: "details.two"
            }, "Painless budgeting")), a.createElement("p", {
                className: "mt-2 text-monochrome-shade"
            }, a.createElement(s.Z, {
                id: "details.one.desc"
            }, "Set budgets that are easy to stick to, based on your own spending habits. You\u2019re one step closer to that stuff you want to buy."))), a.createElement("div", {
                className: "col-span-full md:col-span-5 md:col-start-7 md:place-self-center md:self-center"
            }, a.createElement("div", {
                className: (0,
                f.Z)(v, "md:w-11/12 mx-auto")
            }, a.createElement("img", {
                src: (0,
                o.Z)("img/details/budget@4x.png"),
                alt: "risks and tests to run"
            })))), a.createElement(x, null, a.createElement("figcaption", {
                className: "col-span-full md:col-span-5 md:col-start-7 md:place-self-center md:self-center md:order-2"
            }, a.createElement("h3", {
                className: "text-26 tracking-tighter font-medium md:text-26 lg:text-40 md:leading-52 leading-32 text-dark-tiny"
            }, a.createElement(s.Z, {
                id: "details.three"
            }, "The whole picture in one place")), a.createElement("p", {
                className: "mt-2 text-monochrome-shade"
            }, a.createElement(s.Z, {
                id: "details.three.desc"
            }, "One report to give a clear view on your spending patterns. Understand where your money comes and goes with easy-to-read graphs."))), a.createElement("div", {
                className: "md:order-1 col-span-full md:col-span-5 md:col-start-2 md:place-self-center md:self-center"
            }, a.createElement("div", {
                className: (0,
                f.Z)(v, "md:w-11/12 mx-auto")
            }, a.createElement("img", {
                src: (0,
                o.Z)("img/details/REPORT@4x.png"),
                alt: "time savings"
            })))))
        }
          , E = [{
            image: "img/features/1.svg",
            title: (0,
            s.I)({
                id: "features.multiple.devices",
                message: "Multiple devices"
            }),
            desc: (0,
            s.I)({
                id: "features.multiple.devices.desc",
                message: "Safely synchronize across devices with Bank standard security."
            })
        }, {
            image: "img/features/2.svg",
            title: (0,
            s.I)({
                id: "features.recurring.transaction",
                message: "Recurring transaction"
            }),
            desc: (0,
            s.I)({
                id: "features.recurring.transaction.desc",
                message: "Get notified of recurring bills and transactions before due date."
            })
        }, {
            image: "img/features/3.svg",
            title: (0,
            s.I)({
                id: "features.travel.mode",
                message: "Travel mode"
            }),
            desc: (0,
            s.I)({
                id: "features.travel.mode.desc",
                message: "All currencies supported with up-to-date exchange rate."
            })
        }, {
            image: "img/features/4.svg",
            title: (0,
            s.I)({
                id: "features.saving.plan",
                message: "Saving plan"
            }),
            desc: (0,
            s.I)({
                id: "features.saving.plan.desc",
                message: "Keep track on savings process to meet your financial goals."
            })
        }, {
            image: "img/features/5.svg",
            title: (0,
            s.I)({
                id: "features.debt.and.loan",
                message: "Debt and loan"
            }),
            desc: (0,
            s.I)({
                id: "features.debt.and.loan.desc",
                message: "Manage your debts, loans and payment process in one place."
            })
        }, {
            image: "img/features/6.svg",
            title: (0,
            s.I)({
                id: "features.scan.receipt",
                message: "Scan receipts"
            }),
            desc: (0,
            s.I)({
                id: "features.scan.receipt.desc",
                message: "Take pictures of your receipts to auto-process and organize them."
            })
        }]
          , y = function() {
            return a.createElement("section", {
                className: "container mt-14 lg:mt-44"
            }, a.createElement("h2", {
                className: "text-26 tracking-tight lg:text-40 lg:leading-52 text-dark-tiny leading-32 font-medium text-center"
            }, a.createElement(s.Z, null, "Features our users love")), a.createElement("div", {
                className: "grid mt-6 lg:mt-12 gap-y-8 lg:gap-x-10 lg:gap-y-12 grid-cols-1 lg:grid-cols-3"
            }, E && E.map((function(e) {
                var t = e.image
                  , n = e.title
                  , l = e.desc;
                return a.createElement("div", {
                    key: Math.random(),
                    className: "flex flex-col items-center"
                }, a.createElement("img", {
                    src: (0,
                    o.Z)(t),
                    alt: n
                }), a.createElement("h3", {
                    className: "text-16 lg:text-20 lg:leading-28 font-bold lg:mt-6 leading-24 text-center mt-3 text-dark-tiny"
                }, n), a.createElement("p", {
                    className: "pt-1 px-4 lg:pt-2 text-16 leading-24 text-dark-brown text-center"
                }, l))
            }
            ))))
        }
          , w = n(6742)
          , k = n(9755)
          , N = n.n(k)
          , Z = function(e) {
            e.to;
            var t = e.sendGaEvent
              , n = (0,
            a.useRef)(null);
            return (0,
            a.useEffect)((function() {
                N().fn.isOnScreen = function() {
                    var e = N()(window)
                      , t = {
                        top: e.scrollTop(),
                        left: e.scrollLeft(),
                        right: 0,
                        bottom: 0
                    };
                    t.right = t.left + e.width(),
                    t.bottom = t.top + e.height();
                    var n = this.offset();
                    return n.right = n.left + this.outerWidth(),
                    n.bottom = n.top + this.outerHeight(),
                    !(t.right < n.left || t.left > n.right || t.bottom < n.top || t.top > n.bottom)
                }
                ,
                N()(window).scroll((function() {
                    1 == N()("#cta").isOnScreen() ? n.current && n.current.classList.add("invisible") : n.current && (window.scrollY >= 330 ? n.current && n.current.classList.remove("invisible") : n.current && n.current.classList.add("invisible"))
                }
                ))
            }
            )),
            a.createElement("div", {
                className: "container md:pt-20 pb:12 lg:mb-24 md:h-full"
            }, a.createElement("div", {
                className: "md:px-14 lg:px-44"
            }, a.createElement("h1", {
                className: "font-ibm tracking-tight lg:text-64 lg:leading-83 font-medium text-36 md:text-64 text-green-ml leading-52 md:leading-83 mb-1 text-center"
            }, a.createElement(s.Z, null, "Simple way")), a.createElement("p", {
                className: "font-ibm text-36 text-dark-brown leading-48 md:leading-56 md:text-40 text-center"
            }, a.createElement("h1", {
                className: "font-ibm tracking-tight lg:text-64 lg:leading-83 text-dark-brown font-light text-36 leading-48 md:inline"
            }, a.createElement(s.Z, null, "to manage"), " "), a.createElement("h1", {
                className: "font-ibm tracking-tight lg:text-64 lg:leading-83 font-medium text-36 leading-48 md:inline text-green-ml"
            }, a.createElement(s.Z, null, "personal finances"))), a.createElement("div", {
                className: "grid grid-cols-2 gap-x-2 lg:gap-x-4 md:flex md:justify-center mt-9 lg:mt-12"
            }, a.createElement(w.Z, {
                style: {
                    textDecoration: "none"
                },
                className: "button-ml text-16 md:w-full",
                target: "_blank",
                onClick: t("tryOnWeb"),
                to: "https://web.moneylover.me"
            }, a.createElement(s.Z, null, "Try on browser")), a.createElement(w.Z, {
                style: {
                    textDecoration: "none"
                },
                className: "button-ml-primary bg-green-ml text-16 md:w-full",
                to: "#cta",
                onClick: t("download")
            }, a.createElement(s.Z, null, "Download for free"))), a.createElement("div", {
                ref: n,
                style: {
                    boxShadow: "0px -4px 16px rgba(0, 0, 0, 0.04)"
                },
                className: "invisible lg:invisible fixed bg-monochrome-white bottom-0 inset-x-0 z-10 flex justify-around"
            }, a.createElement("div", {
                className: "grid grid-cols-2 gap-2 mx-4 my-4"
            }, a.createElement(w.Z, {
                style: {
                    textDecoration: "none"
                },
                className: "button-ml text-16 md:w-full",
                target: "_blank",
                onClick: t("tryOnWeb"),
                href: "https://web.moneylover.me"
            }, a.createElement(s.Z, null, "Try on browser")), a.createElement(w.Z, {
                style: {
                    textDecoration: "none"
                },
                className: "button-ml-primary bg-green-ml text-16 md:w-full",
                to: "#cta",
                onClick: t("download")
            }, a.createElement(s.Z, null, "Download for free"))))))
        }
          , I = n(5697)
          , O = function(e) {
            var t = e.sendGaEvent;
            return a.createElement("section", {
                id: "cta",
                className: "container mt-18 lg:mt-44 lg:mb-14"
            }, a.createElement("div", {
                className: "relative grid grid-cols-12 bg-green-ml py-12 lg:py-20 rounded-2xl"
            }, a.createElement("div", {
                className: "col-span-12 col-start-1 lg:col-start-3 lg:col-end-8"
            }, a.createElement("p", {
                className: "mb-2 text-center tracking-tight lg:text-left text-monochrome-white text-24 leading-32 font-medium lg:font-medium lg:text-40 lg:leading-52"
            }, (0,
            s.I)({
                id: "cta.slogan"
            })), a.createElement("p", {
                style: {
                    color: "#F3F3F3"
                },
                className: "mb-9 tracking-tight text-center lg:text-left leading-32"
            }, (0,
            s.I)({
                id: "cta.slogan.sub"
            })), a.createElement("div", {
                className: "flex justify-center lg:justify-start w-full"
            }, a.createElement(w.Z, {
                target: "_blank",
                to: "https://itunes.apple.com/app/apple-store/id486312413?pt=694013&ct=landing&mt=8",
                className: "mr-1",
                onClick: function() {
                    return t("goAppStore")
                }
            }, a.createElement("img", {
                src: (0,
                o.Z)("img/marketplace/appstore.svg"),
                alt: ""
            })), a.createElement(w.Z, {
                target: "_blank",
                to: "https://play.google.com/store/apps/details?id=com.bookmark.money&referrer=utm_source%3Dlanding",
                className: "ml-1",
                onClick: function() {
                    return t("goPlayStore")
                }
            }, a.createElement("img", {
                src: (0,
                o.Z)("img/marketplace/google-play.svg"),
                alt: ""
            })))), a.createElement("img", {
                className: "invisible w-1/5 lg:visible absolute bottom-0 lg:left-2/3",
                src: (0,
                o.Z)("img/MOCKUP@4x.png"),
                alt: ""
            })))
        };
        O.propTypes = {
            sendGaEvent: n.n(I)().func
        };
        var z = n(3485);
        var S = function() {
            var e = (0,
            r.LU)().navbar.items
              , t = e[e.length - 1]
              , n = (t.label,
            t.to)
              , o = (0,
            a.useState)(!1)
              , c = o[0]
              , d = o[1]
              , g = (0,
            a.useState)(!1)
              , p = g[0]
              , f = g[1]
              , h = (0,
            a.useState)(!1)
              , v = h[0]
              , x = h[1];
            (0,
            a.useEffect)((function() {
                "undefined" != typeof window && void 0 !== window.navigator && (d(!!/Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent)),
                f(!!navigator.platform && /iPad|iPhone|iPod/.test(navigator.platform)),
                x(/(android)/i.test(navigator.userAgent)))
            }
            ), []);
            var E = function(e) {
                var t = "BrowserPC"
                  , n = c ? "mobile" : "web";
                "mobile" === n && (t = p ? "Ios" : v ? "Android" : "Mobile"),
                z.Z.event({
                    category: e,
                    action: t,
                    label: n
                })
            };
            return a.createElement(l.Z, {
                title: (0,
                s.I)({
                    id: "title",
                    message: "No.1 Expense Manager & Budget Planner - Money Lover"
                }),
                description: "Simple way to manage personal finances"
            }, a.createElement("main", {
                className: i
            }, a.createElement(Z, {
                sendGaEvent: E,
                to: n
            }), a.createElement(u, null), a.createElement(b, null), a.createElement(y, null), a.createElement(m, null), a.createElement(O, {
                sendGaEvent: E
            })))
        }
    },
    8494: function(e, t, n) {
        n.d(t, {
            Z: function() {
                return N
            }
        });
        var a, l, r = n(7294), i = n(6742), o = ["title", "titleId"];
        function c() {
            return c = Object.assign || function(e) {
                for (var t = 1; t < arguments.length; t++) {
                    var n = arguments[t];
                    for (var a in n)
                        Object.prototype.hasOwnProperty.call(n, a) && (e[a] = n[a])
                }
                return e
            }
            ,
            c.apply(this, arguments)
        }
        function s(e, t) {
            if (null == e)
                return {};
            var n, a, l = function(e, t) {
                if (null == e)
                    return {};
                var n, a, l = {}, r = Object.keys(e);
                for (a = 0; a < r.length; a++)
                    n = r[a],
                    t.indexOf(n) >= 0 || (l[n] = e[n]);
                return l
            }(e, t);
            if (Object.getOwnPropertySymbols) {
                var r = Object.getOwnPropertySymbols(e);
                for (a = 0; a < r.length; a++)
                    n = r[a],
                    t.indexOf(n) >= 0 || Object.prototype.propertyIsEnumerable.call(e, n) && (l[n] = e[n])
            }
            return l
        }
        var m, d, g = ["title", "titleId"];
        function p() {
            return p = Object.assign || function(e) {
                for (var t = 1; t < arguments.length; t++) {
                    var n = arguments[t];
                    for (var a in n)
                        Object.prototype.hasOwnProperty.call(n, a) && (e[a] = n[a])
                }
                return e
            }
            ,
            p.apply(this, arguments)
        }
        function u(e, t) {
            if (null == e)
                return {};
            var n, a, l = function(e, t) {
                if (null == e)
                    return {};
                var n, a, l = {}, r = Object.keys(e);
                for (a = 0; a < r.length; a++)
                    n = r[a],
                    t.indexOf(n) >= 0 || (l[n] = e[n]);
                return l
            }(e, t);
            if (Object.getOwnPropertySymbols) {
                var r = Object.getOwnPropertySymbols(e);
                for (a = 0; a < r.length; a++)
                    n = r[a],
                    t.indexOf(n) >= 0 || Object.prototype.propertyIsEnumerable.call(e, n) && (l[n] = e[n])
            }
            return l
        }
        var f, h, v = ["title", "titleId"];
        function x() {
            return x = Object.assign || function(e) {
                for (var t = 1; t < arguments.length; t++) {
                    var n = arguments[t];
                    for (var a in n)
                        Object.prototype.hasOwnProperty.call(n, a) && (e[a] = n[a])
                }
                return e
            }
            ,
            x.apply(this, arguments)
        }
        function b(e, t) {
            if (null == e)
                return {};
            var n, a, l = function(e, t) {
                if (null == e)
                    return {};
                var n, a, l = {}, r = Object.keys(e);
                for (a = 0; a < r.length; a++)
                    n = r[a],
                    t.indexOf(n) >= 0 || (l[n] = e[n]);
                return l
            }(e, t);
            if (Object.getOwnPropertySymbols) {
                var r = Object.getOwnPropertySymbols(e);
                for (a = 0; a < r.length; a++)
                    n = r[a],
                    t.indexOf(n) >= 0 || Object.prototype.propertyIsEnumerable.call(e, n) && (l[n] = e[n])
            }
            return l
        }
        var E = [{
            Icon: function(e) {
                var t = e.title
                  , n = e.titleId
                  , i = s(e, o);
                return r.createElement("svg", c({
                    width: 32,
                    height: 32,
                    viewBox: "0 0 32 32",
                    fill: "none",
                    xmlns: "http://www.w3.org/2000/svg",
                    "aria-labelledby": n
                }, i), t ? r.createElement("title", {
                    id: n
                }, t) : null, a || (a = r.createElement("path", {
                    d: "M14.546 12.363v1.455H13.09V16h1.455v6.545h2.909V16h1.935l.247-2.182h-2.182v-1.273c0-.589.058-.902.967-.902h1.215V9.454h-1.95c-2.327 0-3.141 1.091-3.141 2.91z",
                    fill: "#000",
                    fillOpacity: .54
                })), l || (l = r.createElement("path", {
                    d: "M16 0C7.163 0 0 7.163 0 16s7.163 16 16 16 16-7.163 16-16S24.837 0 16 0zm0 30.545C7.967 30.545 1.455 24.033 1.455 16 1.455 7.967 7.967 1.455 16 1.455c8.033 0 14.545 6.512 14.545 14.545 0 8.033-6.512 14.545-14.545 14.545z",
                    fill: "#000",
                    fillOpacity: .54
                })))
            },
            bg: "bg-fb",
            link: "https://www.facebook.com/moneylover.me"
        }, {
            Icon: function(e) {
                var t = e.title
                  , n = e.titleId
                  , a = u(e, g);
                return r.createElement("svg", p({
                    width: 32,
                    height: 32,
                    viewBox: "0 0 32 32",
                    fill: "none",
                    xmlns: "http://www.w3.org/2000/svg",
                    "aria-labelledby": n
                }, a), t ? r.createElement("title", {
                    id: n
                }, t) : null, m || (m = r.createElement("path", {
                    d: "M16 0C7.163 0 0 7.163 0 16s7.163 16 16 16 16-7.163 16-16S24.837 0 16 0zm0 30.545C7.967 30.545 1.455 24.033 1.455 16 1.455 7.967 7.967 1.455 16 1.455c8.033 0 14.545 6.512 14.545 14.545 0 8.033-6.512 14.545-14.545 14.545z",
                    fill: "#000",
                    fillOpacity: .54
                })), d || (d = r.createElement("path", {
                    d: "M20.364 8.727h-8.727a2.91 2.91 0 00-2.91 2.91v8.726a2.909 2.909 0 002.91 2.91h8.727a2.909 2.909 0 002.909-2.91v-8.727a2.909 2.909 0 00-2.91-2.909zm-1.455 2.182h2.182v2.182H18.91v-2.182zM16 13.09a2.91 2.91 0 110 5.818 2.91 2.91 0 010-5.818zm5.818 7.272c0 .804-.65 1.455-1.454 1.455h-8.727a1.455 1.455 0 01-1.455-1.455v-5.09h1.527a4.364 4.364 0 108.582 0h1.527v5.09z",
                    fill: "#000",
                    fillOpacity: .54
                })))
            },
            bg: "bg-ig",
            link: "https://www.instagram.com/moneyloverapp/"
        }, {
            Icon: function(e) {
                var t = e.title
                  , n = e.titleId
                  , a = b(e, v);
                return r.createElement("svg", x({
                    width: 32,
                    height: 32,
                    viewBox: "0 0 32 32",
                    fill: "none",
                    xmlns: "http://www.w3.org/2000/svg",
                    "aria-labelledby": n
                }, a), t ? r.createElement("title", {
                    id: n
                }, t) : null, f || (f = r.createElement("path", {
                    d: "M23.6 10.4a6.046 6.046 0 01-1.898.727 3.004 3.004 0 00-2.182-.93 2.96 2.96 0 00-2.982 2.908c0 .226.028.45.08.67a8.517 8.517 0 01-6.153-3.07 2.91 2.91 0 00-.407 1.455c0 .988.501 1.908 1.331 2.444a3.012 3.012 0 01-1.353-.371v.036a2.953 2.953 0 002.393 2.91 3.05 3.05 0 01-1.345.05 2.982 2.982 0 002.785 2.037 6.044 6.044 0 01-4.414 1.229 8.545 8.545 0 004.574 1.323 8.364 8.364 0 008.517-8.356v-.378A6.046 6.046 0 0024 11.564a6.035 6.035 0 01-1.716.465A2.96 2.96 0 0023.6 10.4z",
                    fill: "#000",
                    fillOpacity: .54
                })), h || (h = r.createElement("path", {
                    d: "M16 0C7.163 0 0 7.163 0 16s7.163 16 16 16 16-7.163 16-16S24.837 0 16 0zm0 30.545C7.967 30.545 1.455 24.033 1.455 16 1.455 7.967 7.967 1.455 16 1.455c8.033 0 14.545 6.512 14.545 14.545 0 8.033-6.512 14.545-14.545 14.545z",
                    fill: "#000",
                    fillOpacity: .54
                })))
            },
            bg: "bg-twitter",
            link: "https://www.twitter.com/moneyloverapp"
        }]
          , y = n(6010)
          , w = n(4973)
          , k = [{
            to: "https://finsify.com/",
            label: (0,
            w.I)({
                id: "about",
                message: "About us"
            })
        }, {
            to: "/career",
            label: (0,
            w.I)({
                id: "career",
                message: "Career"
            })
        }, {
            to: "https://note.moneylover.me/",
            label: (0,
            w.I)({
                message: "Blog"
            })
        }, {
            label: (0,
            w.I)({
                id: "privacy.policy",
                message: "Privacy policy"
            }),
            to: "/policy"
        }]
          , N = function() {
            return r.createElement("footer", {
                className: (0,
                y.Z)("lg:py-6 lg:m-0 mt-10 border-t border-monochrome-medium-tint")
            }, r.createElement("section", {
                className: "container grid grid-cols-1 lg:grid-cols-12 gap-y-8 lg:gap-x-8 lg:mx-auto"
            }, r.createElement("p", {
                className: "flex items-center mt-6 lg:mt-0 lg:col-span-6 text-16 leading-24 text-dark-brown"
            }, "\xa9 2022 Finsify Technology Co., Ltd. All rights reserved."), r.createElement("div", {
                className: "flex flex-col lg:flex-row justify-center gap-y-4 lg:col-span-5 lg:gap-x-4"
            }, k.map((function(e) {
                var t = e.label
                  , n = e.to;
                return r.createElement(i.Z, {
                    key: Math.random(),
                    to: n,
                    target: "_blank",
                    className: "flex items-center leading-24 text-16 font-medium text-dark-brown hover:no-underline"
                }, t)
            }
            ))), r.createElement("ul", {
                className: "lg:col-span-1 lg:place-self-end flex items-center justify-start mt-5 mb-8 lg:mt-0 lg:mb-0 gap-x-2"
            }, E.map((function(e) {
                var t = e.Icon
                  , n = e.link;
                return r.createElement("li", {
                    key: n
                }, r.createElement(i.Z, {
                    to: n,
                    className: "cursor-pointer hover:no-underline"
                }, r.createElement(t, {
                    width: 32,
                    height: 32
                })))
            }
            )))))
        }
    },
    6178: function(e, t, n) {
        n.d(t, {
            Z: function() {
                return v
            }
        });
        var a = n(7294)
          , l = n(4996)
          , r = n(5977)
          , i = n(6742)
          , o = n(6700)
          , c = n(8232)
          , s = n(1839)
          , m = n(6010)
          , d = n(9105)
          , g = "header_GVHt"
          , p = "headerHidden_kyDz"
          , u = n(4973)
          , f = [{
            to: "https://finsify.com/",
            label: (0,
            u.I)({
                id: "about",
                message: "About us"
            })
        }, {
            to: "/career",
            label: (0,
            u.I)({
                id: "career",
                message: "Career"
            })
        }]
          , h = n(2263)
          , v = function() {
            var e, t = (0,
            h.default)().i18n, n = (t.currentLocale,
            t.locales), v = (t.localeConfigs,
            (0,
            o.l5)(),
            n.map((function(e) {
                return {
                    locale: e
                }
            }
            ))), x = function(e) {
                return b.includes("/vi") || "en" !== e ? b.includes("/vi") && "vi" === e ? a.createElement("li", {
                    className: "border-t border-monochrome-medium-tint md:border-none"
                }, a.createElement("a", {
                    style: {
                        textDecoration: "none"
                    },
                    className: (0,
                    m.Z)("inline-flex text-16 font-medium text-dark-brown leading-24 py-4 gap-x-1 w-full h-full"),
                    href: "/"
                }, a.createElement("img", {
                    className: "w-6 inline-block",
                    src: (0,
                    l.Z)("/img/en.svg"),
                    alt: "English"
                }), " ", "English")) : void 0 : a.createElement("li", {
                    className: "border-t border-monochrome-medium-tint md:border-none"
                }, a.createElement("a", {
                    style: {
                        textDecoration: "none"
                    },
                    className: (0,
                    m.Z)("inline-flex text-16 font-medium text-dark-brown leading-24 py-4 w-full h-full gap-x-2"),
                    href: "/vi"
                }, a.createElement("img", {
                    className: "w-6 inline-block",
                    src: (0,
                    l.Z)("/img/vi.svg"),
                    alt: "Vietnam"
                }), "Vietnamese"))
            }, b = (0,
            r.TH)().pathname, E = (0,
            a.useState)(!1), y = E[0], w = E[1];
            (0,
            s.Z)(y);
            var k = [].concat(f)
              , N = (0,
            c.Z)(!0)
              , Z = N.navbarRef
              , I = N.isNavbarVisible;
            return a.createElement("header", {
                ref: Z,
                className: (0,
                m.Z)("fixed top-0 inset-x-0 z-50 h-20 bg-transparent border-none", g, (e = {},
                e[p] = !I,
                e))
            }, a.createElement(d.Z, null, a.createElement("meta", {
                name: "author",
                content: "Finsify Technology Co., Ltd"
            }), a.createElement("meta", {
                property: "al:android:url",
                content: "https://moneylover.me/download"
            }), a.createElement("meta", {
                property: "al:android:package",
                content: "com.bookmark.money"
            }), a.createElement("meta", {
                property: "al:android:app_name",
                content: "MoneyLover"
            }), a.createElement("meta", {
                name: "keywords",
                content: (0,
                u.I)({
                    id: "meta.keywords"
                })
            }), a.createElement("meta", {
                name: "description",
                content: (0,
                u.I)({
                    id: "meta.description"
                })
            }), a.createElement("meta", {
                property: "og:title",
                content: (0,
                u.I)({
                    id: "og.title"
                })
            }), a.createElement("meta", {
                property: "og:description",
                content: (0,
                u.I)({
                    id: "og.description"
                })
            }), a.createElement("meta", {
                property: "og:type",
                content: "website"
            }), a.createElement("meta", {
                property: "og:url",
                content: "https://moneylover.me/"
            }), a.createElement("meta", {
                property: "og:site_name",
                content: "Moneylover"
            }), a.createElement("meta", {
                property: "og:image",
                content: (0,
                l.Z)("/img/ml-cover.png")
            }), a.createElement("meta", {
                property: "fb:app_id",
                content: "192450854108398"
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "57x57",
                href: (0,
                l.Z)("img/favicons/apple-icon-57x57.png")
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "114x114",
                href: (0,
                l.Z)("img/favicons/apple-icon-114x114.png")
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "72x72",
                href: (0,
                l.Z)("img/favicons/apple-icon-72x72.png")
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "144x144",
                href: (0,
                l.Z)("img/favicons/apple-icon-144x144.png")
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "60x60",
                href: (0,
                l.Z)("img/favicons/apple-icon-60x60.png")
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "120x120",
                href: (0,
                l.Z)("img/favicons/apple-icon-120x120.png")
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "76x76",
                href: (0,
                l.Z)("img/favicons/apple-icon-76x76.png")
            }), a.createElement("link", {
                rel: "apple-touch-icon-precomposed",
                sizes: "152x152",
                href: (0,
                l.Z)("img/favicons/apple-icon-152x152.png")
            }), a.createElement("link", {
                rel: "icon",
                type: "image/png",
                href: (0,
                l.Z)("img/favicons/favicon-196x196.png"),
                sizes: "196x196"
            }), a.createElement("link", {
                rel: "icon",
                type: "image/png",
                href: (0,
                l.Z)("img/favicons/favicon-96x96.png"),
                sizes: "96x96"
            }), a.createElement("link", {
                rel: "icon",
                type: "image/png",
                href: (0,
                l.Z)("img/favicons/favicon-32x32.png"),
                sizes: "32x32"
            }), a.createElement("link", {
                rel: "icon",
                type: "image/png",
                href: (0,
                l.Z)("img/favicons/favicon-16x16.png"),
                sizes: "16x16"
            }), a.createElement("link", {
                rel: "icon",
                type: "image/png",
                href: (0,
                l.Z)("img/favicons/favicon-128.png"),
                sizes: "128x128"
            }), a.createElement("meta", {
                name: "application-name",
                content: "Money Lover"
            }), a.createElement("meta", {
                name: "msapplication-TileColor",
                content: "#FFFFFF"
            }), a.createElement("meta", {
                name: "msapplication-TileImage",
                content: (0,
                l.Z)("img/favicons/ms-icon-144x144.png")
            }), a.createElement("meta", {
                name: "msapplication-square70x70logo",
                content: (0,
                l.Z)("img/favicons/ms-icon-70x70.png")
            }), a.createElement("meta", {
                name: "msapplication-square150x150logo",
                content: (0,
                l.Z)("img/favicons/ms-icon-150x150.png")
            }), a.createElement("meta", {
                name: "msapplication-wide310x150logo",
                content: (0,
                l.Z)("img/favicons/mstile-310x150.png")
            }), a.createElement("meta", {
                name: "msapplication-square310x310logo",
                content: (0,
                l.Z)("img/favicons/ms-icon-310x310.png")
            }), a.createElement("script", {
                id: "ze-snippet",
                src: "https://static.zdassets.com/ekr/snippet.js?key=cb0be492-0505-495c-8751-093cf97db217"
            }), a.createElement("script", {
                src: (0,
                l.Z)("/config-zendesk.js")
            })), a.createElement("div", {
                className: "absolute top-0 left-0 z-40 w-full bg-monochrome-white"
            }, a.createElement("nav", {
                className: "flex items-center justify-between h-20 container"
            }, a.createElement(i.Z, {
                to: (0,
                l.Z)("/")
            }, a.createElement("img", {
                className: "w-48",
                src: (0,
                l.Z)("/img/logo.svg"),
                alt: "Money Lover"
            })), a.createElement("div", {
                className: "md:flex items-center"
            }, a.createElement("ul", {
                className: "invisible md:visible fixed md:static flex flex-row gap-6 lg:gap-x-8 items-center mt-1"
            }, k.map((function(e) {
                var t = e.to
                  , n = void 0 === t ? "" : t
                  , r = e.label
                  , o = void 0 === r ? "" : r;
                return a.createElement("li", {
                    key: n
                }, a.createElement(i.Z, {
                    style: {
                        textDecoration: "none"
                    },
                    className: "flex items-center font-medium \n                      text-16 text-dark-brown",
                    to: (0,
                    l.Z)(n)
                }, o))
            }
            )), v && v.map((function(e) {
                var t = e.locale;
                return x(t)
            }
            ))), a.createElement("button", {
                "aria-label": "menu button",
                style: {
                    backgroundPosition: "center"
                },
                className: (0,
                m.Z)("flex items-center justify-center w-9 h-9 md:hidden text-green-ml fill-current " + (y ? "bg-close" : "bg-menu") + " bg-no-repeat"),
                type: "button",
                onClick: function() {
                    return w(!y)
                }
            })))), y && a.createElement("nav", {
                className: "visible md:invisible fixed w-full h-20 left-0 top-14"
            }, a.createElement("div", {
                className: "bg-monochrome-white"
            }, a.createElement("div", {
                className: "container mt-4 pt-2 pb-4"
            }, a.createElement("ul", null, k.map((function(e) {
                var t = e.to
                  , n = void 0 === t ? "" : t
                  , r = e.label
                  , o = void 0 === r ? "" : r;
                return a.createElement("li", {
                    className: "border-t border-monochrome-medium-tint"
                }, a.createElement(i.Z, {
                    style: {
                        textDecoration: "none"
                    },
                    className: "inline-flex text-16 font-medium text-dark-brown leading-24 py-4 w-full h-full",
                    to: (0,
                    l.Z)(n),
                    onClick: function() {
                        return w(!1)
                    }
                }, a.createElement(u.Z, null, o)))
            }
            )), v && v.map((function(e) {
                var t = e.locale;
                return x(t)
            }
            ))))), a.createElement("div", {
                className: "w-full h-full bg-monochrome-black bg-opacity-50",
                onClick: function() {
                    return w(!y)
                }
            })))
        }
    }
}]);
