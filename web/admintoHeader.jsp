<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GesCons</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<%--header--%>
<header id="topnav">
    <div class="topbar-main">
        <div class="container-fluid">
            <div class="logo">
                <%--                <!-- Text Logo -->--%>
                <a href="#" class="logo">
                    <span class="logo-small"><i class="mdi mdi-radar"></i></span>
                    <span class="logo-large"><i class="mdi mdi-radar"></i> GesCons</span>
                </a>
            </div>

            <div class="menu-extras topbar-custom">

                <ul class="list-unstyled topbar-right-menu float-right mb-0">

                    <li class="menu-item">

                        <a class="navbar-toggle nav-link">
                            <div class="lines">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                        </a>

                    </li>
                    <li class="hide-phone">
                        <form class="app-search">
                            <input type="text" placeholder="Search..."
                                   class="form-control">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </li>
                    <li>

                        <div class="notification-box">
                            <ul class="list-inline mb-0">
                                <li>
                                    <a href="javascript:void(0);" class="right-bar-toggle">
                                        <i class="mdi mdi-bell-outline noti-icon"></i>
                                    </a>
                                    <div class="noti-dot">
                                        <span class="dot"></span>
                                        <span class="pulse"></span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!-- End Notification bar -->
                    </li>

                    <li class="dropdown notification-list">
                        <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown"
                           href="#" role="button"
                           aria-haspopup="false" aria-expanded="false">
                            <img src="assets/images/users/avatar-1.jpg" alt="user" class="rounded-circle">
                        </a>
                        <div class="dropdown-menu dropdown-menu-right profile-dropdown ">

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="ti-user m-r-5"></i> Profile
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="ti-settings m-r-5"></i> Settings
                            </a>

                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="ti-lock m-r-5"></i> Lock screen
                            </a>

                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="ti-power-off m-r-5"></i> Logout
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="navbar-custom">
        <div class="container-fluid">
            <div id="navigation">
                <% String medecin = (String) session.getAttribute("medecin");%>
                <% String caissier = (String) session.getAttribute("caissier");%>

                <ul class="navigation-menu">
                    <% if (medecin != null) { %>
                    <li class="has-submenu">
                        <a href="Medecin"><i class="mdi mdi-view-agenda"></i> <span> Medecin </span> </a>
                    </li>
                    <li class="has-submenu">
                        <a href="Consultation"><i class="mdi mdi-view-column"></i> <span> Consultation </span> </a>
                    </li>
                    <li class="has-submenu">
                        <a href="Ticket"><i class="mdi mdi-view-column"></i> <span> Ticket </span> </a>
                    </li>
                    <% } %>
                    <% if (caissier != null) { %>
                    <li class="has-submenu">
                        <a href="PatientController"><i class="mdi mdi-view-dashboard"></i> <span> Patient </span> </a>
                    </li>
                    <li class="has-submenu">
                        <a href="Ticket"><i class="mdi mdi-view-column"></i> <span> Ticket </span> </a>
                    </li>
                    <% } %>
                    <li class="has-submenu">
                        <a href="Specialite"><i class="mdi mdi-view-list"></i> <span> Specialite </span> </a>
                    </li>
                    <li class="has-submenu">
                        <a href="Caissier"><i class="mdi mdi-view-split-horizontal"></i> <span> Caissier </span> </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<%--header--%>

<%--Contenu div--%>
<div class="wrapper">
    <div class="container-fluid">
