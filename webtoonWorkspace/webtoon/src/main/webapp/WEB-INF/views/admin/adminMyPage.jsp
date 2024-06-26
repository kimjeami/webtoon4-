<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/util.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webtoon/resources/css/my_page.css">
    <title>MoonToon AdminMyPage</title>
</head>
<body>
    <header>
        <a href="/webtoon/home"><img id="logo" src="/webtoon/resources/img/logo/moonlogo.png" alt="문툰로고"></a>
    </header>
    <hr>
    <div class="user-info">
        <div class="user-image">👤</div>
        <div class="user-details">
            <div>${sessionScope.loginAdminVo.nick}</div>
            <div>서버관리자</div>
            <button onclick="location.href='/webtoon/admin/edit'">정보수정</button>
        </div>
    </div>
    <hr>
    <div class="coin-box">
        <span>보유 M코인: ∞ <img id="icon02" src="/webtoon/resources/img/icon/동전.png" alt=""></span>
    </div>
    <hr>
    <ul>
        
        <li><a href="/webtoon/admin/memberInquiry"><div class="icon"><img src="/webtoon/resources/img/icon/고객센터.png" alt="고객센터 아이콘"></div>회원조회</a></li>
        <hr>
        <li><a href="/webtoon/board/notion/list"><div class="icon"><img src="/webtoon/resources/img/icon/공지사항.png" alt="공지사항 아이콘"></div>공지사항 수정</a></li>
        <hr>
        <li><a href="/webtoon/home/insert"><div class="icon"><img src="/webtoon/resources/img/icon/고객센터.png" alt="고객센터 아이콘"></div>웹툰등록</a></li>
        <hr>
        <li><a href="/webtoon/episode/insert"><div class="icon"><img src="/webtoon/resources/img/icon/고객센터.png" alt="고객센터 아이콘"></div>회차등록</a></li>
        <hr>
        <li><a href="/webtoon/webtoon/insert"><div class="icon"><img src="/webtoon/resources/img/icon/고객센터.png" alt="고객센터 아이콘"></div>웹툰업로드</a></li>
        <hr>
        <li><a href="/webtoon/admin/look"><div class="icon"><img class="icon01" src="/webtoon/resources/img/icon/회원탈퇴.png" alt="회원탈퇴 아이콘"></div>고객센터 문의확인</a></li>
        <hr>
    </ul>

</body>
</html>