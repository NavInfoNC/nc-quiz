<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录 - 四维图新在线笔试系统 beta 1.2</title>
    <link href="images/web.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/stylebt.css">
    <link rel="stylesheet" href="css/input-style.css">
</head>

<c:choose>
<c:when test="${empty loginMsg}">
<body>
</c:when>
<c:otherwise>
<body onload="alert('${loginMsg}')">
</c:otherwise>
</c:choose>
<div>为了充分展现本站效果，请使用支持 HTML5 的浏览器(Chrome, Edge, IE11, Firefox)来访问本站。<br>如果依然看到这行提示文字，请尝试着多刷新几次本页面。</div>
<form method="post" action="signIn" id="form1">
    <div id="body" >
        <div id="jp_container" role="application" aria-label="media player">
            <div class="jp-type-playlist">
                <div id="jplayer" class="jp-jplayer"></div>
                <div class="jp-time"> <span class="jp-current-time" role="timer" aria-label="time"></span><span class="jp-duration" role="timer" aria-label="duration"></span> </div>
            </div>
        </div>
    </div>
    <div style="margin: 0;padding: 0">
        <div class="input input-kozakura" id="userNameContainer">
            <input class="input-field input-field-kozakura" type="text" id="username"
                   name="username" required>
            <label class="input-label input-label-kozakura" for="userName">
                <span class="input-label-content input-label-content-kozakura" data-content="帐号">请输入用户名</span>
            </label>
            <svg class="graphic graphic-kozakura" width="300%" height="100%" viewBox="0 0 1200 60"
                 preserveAspectRatio="none">
                <path
                        d="M1200,9c0,0-305.005,0-401.001,0C733,9,675.327,4.969,598,4.969C514.994,4.969,449.336,9,400.333,9C299.666,9,0,9,0,9v43c0,0,299.666,0,400.333,0c49.002,0,114.66,3.484,197.667,3.484c77.327,0,135-3.484,200.999-3.484C894.995,52,1200,52,1200,52V9z"></path>
            </svg>
        </div>
    </div>
    <div style="margin: 0;padding: 0">
        <div class="input input-kozakura" id="pswdContainer">
            <input class="input-field input-field-kozakura" type="password" id="pswd" name="password"
                   required>
            <label class="input-label input-label-kozakura" for="pswd">
                <span class="input-label-content input-label-content-kozakura" data-content="密码">请输入密码</span>
            </label>
            <svg class="graphic graphic-kozakura" width="300%" height="100%" viewBox="0 0 1200 60"
                 preserveAspectRatio="none">
                <path
                        d="M1200,9c0,0-305.005,0-401.001,0C733,9,675.327,4.969,598,4.969C514.994,4.969,449.336,9,400.333,9C299.666,9,0,9,0,9v43c0,0,299.666,0,400.333,0c49.002,0,114.66,3.484,197.667,3.484c77.327,0,135-3.484,200.999-3.484C894.995,52,1200,52,1200,52V9z"></path>
            </svg>
        </div>
    </div>
    <div class="link play-link">
        <button type="submit" class="button" data-title="登录" onclick="checkLogin();" href="#">
            <span class="line line-top"></span>
            <span class="line line-right"></span>
            <span class="line line-bottom"></span>
            <span class="line line-left"></span>
            登 录
        </button>
    </div>

    <div style="color:gray; font-family:微软雅黑; font-size:14px; position:relative; top:50px" > &copy; 2019 question.tecyle.com NavInfo All rights reserved.
    </div>
</form>
</body>
</html>
<script type="text/javascript" src="images/jquery.js"></script>
<script type="text/javascript" src="images/ThreeWebGL.js"></script>
<script type="text/javascript" src="images/ThreeExtras.js"></script>
<script type="text/javascript" src="images/Detector.js"></script>
<script type="text/javascript" src="images/RequestAnimationFrame.js"></script>
<script id="vs" type="x-shader/x-vertex">
			varying vec2 vUv;
			void main() {
				vUv = uv;
				gl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );
			}
</script>
<script id="fs" type="x-shader/x-fragment">
			uniform sampler2D map;
			uniform vec3 fogColor;
			uniform float fogNear;
			uniform float fogFar;
			varying vec2 vUv;
			void main() {
				float depth = gl_FragCoord.z / gl_FragCoord.w;
				float fogFactor = smoothstep( fogNear, fogFar, depth );
				gl_FragColor = texture2D( map, vUv );
				gl_FragColor.w *= pow( gl_FragCoord.z, 20.0 );
				gl_FragColor = mix( gl_FragColor, vec4( fogColor, gl_FragColor.w ), fogFactor );
			}
</script>
<script type="text/javascript" src="images/cloud.js"></script>
<script type="text/javascript" src="js/scriptbt.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/classie.js"></script>
<script src="js/jQuery.md5.js"></script>
<script>
    // 特效文本框事件代码
    (function () {
        if (!String.prototype.trim) {
            (function () {
                // Make sure we trim BOM and NBSP
                var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                String.prototype.trim = function () {
                    return this.replace(rtrim, '');
                };
            })();
        }

        [].slice.call(document.querySelectorAll('input.input-field')).forEach(function (inputEl) {
            // in case the input is already filled..
            if (inputEl.value.trim() !== '') {
                classie.add(inputEl.parentNode, 'input-filled');
            }

            // events:
            inputEl.addEventListener('focus', onInputFocus);
            inputEl.addEventListener('blur', onInputBlur);
        });

        function onInputFocus(ev) {
            classie.add(ev.target.parentNode, 'input-filled');
        }

        function onInputBlur(ev) {
            if (ev.target.value.trim() === '') {
                classie.remove(ev.target.parentNode, 'input-filled');
            }
        }
    })();

    function checkLogin(){
        var userName = $("input#userName").val();
        if(userName.replace(/(^s*)|(s*$)/g, "").length == 0){
            alert("用户名不能为空！");
            $("input#userName").focus();
            return false;
        }

        var pswd = $("input#pswd").val();
        if(pswd.replace(/(^s*)|(s*$)/g, "").length == 0){
            alert("密码不能为空！");
            $("input#pswd").focus();
            return false;
        }

        $("input#pswd").val($.md5(pswd));

        return true;
    }
</script>