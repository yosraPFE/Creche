<!DOCTYPE html>
<html lang="en">
<head>
    
    
    <link id="<%=request.getContextPath()%>/resources/bs-css" href="<%=request.getContextPath()%>/resources/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/css/charisma-app.css" rel="stylesheet">
    <link href='<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/jquery.noty.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/noty_theme_default.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/elfinder.min.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/elfinder.theme.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/uploadify.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="<%=request.getContextPath()%>/resources/shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico">

</head>

<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"> <img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs"/>
                <span>Charisma</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> admin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> Change Theme / Skin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li>
                    <form class="navbar-search pull-left">
                        <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
                </li>
            </ul>

        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="index.html"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                        </li>
                        <li><a class="ajax-link" href="ui.html"><i class="glyphicon glyphicon-eye-open"></i><span> UI Features</span></a>
                        </li>
                        <li><a class="ajax-link" href="form.html"><i
                                    class="glyphicon glyphicon-edit"></i><span> Forms</span></a></li>
                        <li><a class="ajax-link" href="chart.html"><i class="glyphicon glyphicon-list-alt"></i><span> Charts</span></a>
                        </li>
                        <li><a class="ajax-link" href="typography.html"><i class="glyphicon glyphicon-font"></i><span> Typography</span></a>
                        </li>
                        <li><a class="ajax-link" href="gallery.html"><i class="glyphicon glyphicon-picture"></i><span> Gallery</span></a>
                        </li>
                        <li class="nav-header hidden-md">Sample Section</li>
                        <li><a class="ajax-link" href="table.html"><i
                                    class="glyphicon glyphicon-align-justify"></i><span> Tables</span></a></li>
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> Accordion Menu</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">Child Menu 1</a></li>
                                <li><a href="#">Child Menu 2</a></li>
                            </ul>
                        </li>
                        <li><a class="ajax-link" href="calendar.html"><i class="glyphicon glyphicon-calendar"></i><span> Calendar</span></a>
                        </li>
                        <li><a class="ajax-link" href="grid.html"><i
                                    class="glyphicon glyphicon-th"></i><span> Grid</span></a></li>
                        <li><a href="tour.html"><i class="glyphicon glyphicon-globe"></i><span> Tour</span></a></li>
                        <li><a class="ajax-link" href="icon.html"><i
                                    class="glyphicon glyphicon-star"></i><span> Icons</span></a></li>
                        <li><a href="error.html"><i class="glyphicon glyphicon-ban-circle"></i><span> Error Page</span></a>
                        </li>
                        <li><a href="login.html"><i class="glyphicon glyphicon-lock"></i><span> Login Page</span></a>
                        </li>
                    </ul>
                    <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
                <div>
        <ul class="breadcrumb">
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#">Gallery</a>
            </li>
        </ul>
    </div>

    <div class="row">
        <div class="box col-md-12">
            <div class="box-inner">
                <div class="box-header well" data-original-title="">
                    <h2><i class="glyphicon glyphicon-picture"></i> Gallery</h2>

                    <div class="box-icon">
                        <a href="#" class="btn btn-setting btn-round btn-default"><i
                                class="glyphicon glyphicon-cog"></i></a>
                        <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                class="glyphicon glyphicon-chevron-up"></i></a>
                        <a href="#" class="btn btn-close btn-round btn-default"><i
                                class="glyphicon glyphicon-remove"></i></a>
                    </div>
                </div>
                <div class="box-content">
                    <br>
                    <ul class="thumbnails gallery">
                                                    <li id="image-1" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/1.jpg)"
                                   title="Sample Image 1" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/1.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/1.jpg"
                                        alt="Sample Image 1"></a>
                            </li>
                                                    <li id="image-2" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/2.jpg)"
                                   title="Sample Image 2" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/2.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/2.jpg"
                                        alt="Sample Image 2"></a>
                            </li>
                                                    <li id="image-3" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/3.jpg)"
                                   title="Sample Image 3" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/3.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/3.jpg"
                                        alt="Sample Image 3"></a>
                            </li>
                                                    <li id="image-4" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/4.jpg)"
                                   title="Sample Image 4" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/4.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/4.jpg"
                                        alt="Sample Image 4"></a>
                            </li>
                                                    <li id="image-5" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/5.jpg)"
                                   title="Sample Image 5" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/5.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/5.jpg"
                                        alt="Sample Image 5"></a>
                            </li>
                                                    <li id="image-6" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/6.jpg)"
                                   title="Sample Image 6" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/6.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/6.jpg"
                                        alt="Sample Image 6"></a>
                            </li>
                                                    <li id="image-7" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/7.jpg)"
                                   title="Sample Image 7" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/7.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/7.jpg"
                                        alt="Sample Image 7"></a>
                            </li>
                                                    <li id="image-8" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/8.jpg)"
                                   title="Sample Image 8" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/8.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/8.jpg"
                                        alt="Sample Image 8"></a>
                            </li>
                                                    <li id="image-9" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/9.jpg)"
                                   title="Sample Image 9" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/9.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/9.jpg"
                                        alt="Sample Image 9"></a>
                            </li>
                                                    <li id="image-10" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/10.jpg)"
                                   title="Sample Image 10" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/10.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/10.jpg"
                                        alt="Sample Image 10"></a>
                            </li>
                                                    <li id="image-11" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/11.jpg)"
                                   title="Sample Image 11" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/11.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/11.jpg"
                                        alt="Sample Image 11"></a>
                            </li>
                                                    <li id="image-12" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/12.jpg)"
                                   title="Sample Image 12" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/12.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/12.jpg"
                                        alt="Sample Image 12"></a>
                            </li>
                                                    <li id="image-13" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/13.jpg)"
                                   title="Sample Image 13" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/13.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/13.jpg"
                                        alt="Sample Image 13"></a>
                            </li>
                                                    <li id="image-14" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/14.jpg)"
                                   title="Sample Image 14" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/14.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/14.jpg"
                                        alt="Sample Image 14"></a>
                            </li>
                                                    <li id="image-15" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/15.jpg)"
                                   title="Sample Image 15" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/15.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/15.jpg"
                                        alt="Sample Image 15"></a>
                            </li>
                                                    <li id="image-16" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/16.jpg)"
                                   title="Sample Image 16" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/16.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/16.jpg"
                                        alt="Sample Image 16"></a>
                            </li>
                                                    <li id="image-17" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/17.jpg)"
                                   title="Sample Image 17" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/17.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/17.jpg"
                                        alt="Sample Image 17"></a>
                            </li>
                                                    <li id="image-18" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/18.jpg)"
                                   title="Sample Image 18" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/18.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/18.jpg"
                                        alt="Sample Image 18"></a>
                            </li>
                                                    <li id="image-19" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/19.jpg)"
                                   title="Sample Image 19" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/19.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/19.jpg"
                                        alt="Sample Image 19"></a>
                            </li>
                                                    <li id="image-20" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/20.jpg)"
                                   title="Sample Image 20" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/20.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/20.jpg"
                                        alt="Sample Image 20"></a>
                            </li>
                                                    <li id="image-21" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/21.jpg)"
                                   title="Sample Image 21" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/21.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/21.jpg"
                                        alt="Sample Image 21"></a>
                            </li>
                                                    <li id="image-22" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/22.jpg)"
                                   title="Sample Image 22" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/22.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/22.jpg"
                                        alt="Sample Image 22"></a>
                            </li>
                                                    <li id="image-23" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/23.jpg)"
                                   title="Sample Image 23" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/23.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/23.jpg"
                                        alt="Sample Image 23"></a>
                            </li>
                                                    <li id="image-24" class="thumbnail">
                                <a style="background:url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/24.jpg)"
                                   title="Sample Image 24" href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/24.jpg"><img
                                        class="grayscale" src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/24.jpg"
                                        alt="Sample Image 24"></a>
                            </li>
                                            </ul>
                </div>
            </div>
        </div>
        <!--/span-->

    </div><!--/row-->

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    <div class="row">
        <div class="col-md-9 col-lg-9 col-xs-9  hidden-xs">
            <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
            <!-- Charisma Demo 2 -->
            <ins class="adsbygoogle"
                 style="display:inline-block;width:728px;height:90px"
                 data-ad-client="ca-pub-5108790028230107"
                 data-ad-slot="3193373905"></ins>
            <script>
                (adsbygoogle = window.adsbygoogle || []).push({});
            </script>
        </div>
        <div class="col-md-2 col-lg-3 col-sm-12 col-xs-12 donate">
            <div>
                <small>Help development of Charisma</small>
            </div>
            <a class="btn btn-default" href="http://flattr.com/thing/1507720/usmanhalalitcharisma-on-GitHub"
               target="_blank"><i class="glyphicon glyphicon-usd green"></i> Donate</a>
        </div>

    </div>
    <!-- Ad ends -->

    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">�</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">Muhammad
                Usman</a> 2012 - 2014</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="<%=request.getContextPath()%>/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.cookie.js"></script>
<script src='<%=request.getContextPath()%>/resources/bower_components/moment/min/moment.min.js'></script>
<script src='<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<script src='<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js'></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/chosen/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/colorbox/jquery.colorbox-min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.noty.js"></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/responsive-tables/responsive-tables.js"></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.raty.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.iphone.toggle.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.autogrow-textarea.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.uploadify-3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.history.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/charisma.js"></script>


</body>
</html>
