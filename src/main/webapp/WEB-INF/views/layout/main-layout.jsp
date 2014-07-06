<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>集资款管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link href="<c:url value='/assets/css/bootstrap.css'/>" rel="stylesheet">
<%-- <link href="<c:url value='/assets/css/bootstrap-theme.css'/>" rel="stylesheet">
<link href="<c:url value='/assets/css/bootstrap-responsive.min.css'/>" rel="stylesheet"> --%>
<style type="text/css">

/* Sticky footer styles
      -------------------------------------------------- */
html,body {
	height: 100%;
	/* The html and body elements cannot have any padding or margin. */
}

/* Wrapper for page content to push down footer */
#wrap {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	/* Negative indent footer by it's height */
	margin: 0 auto -60px;
}

/* Set the fixed height of the footer here */
#push,#footer {
	height: 60px;
}

#footer {
	background-color: #f5f5f5;
}

/* Lastly, apply responsive CSS fixes as necessary */
@media ( max-width : 767px) {
	#footer {
		margin-left: -20px;
		margin-right: -20px;
		padding-left: 20px;
		padding-right: 20px;
	}
}

/* Custom page CSS
      -------------------------------------------------- */
/* Not required for template or sticky footer method. */
.container {
	width: auto;
	max-width: 680px;
}

.container .credit {
	margin: 20px 0;
}
</style>

<%-- <script src="<c:url value='/assets/js/jquery-1.6.2.min.js'/>"></script> --%>
<script src="<c:url value='/assets/js/jquery-1.10.2.min.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->

<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/assets/ico/apple-touch-icon-144-precomposed.png'/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/assets/ico/apple-touch-icon-114-precomposed.png'/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/assets/ico/apple-touch-icon-72-precomposed.png'/>">
<link rel="apple-touch-icon-precomposed" href="<c:url value='/assets/ico/apple-touch-icon-57-precomposed.png'/>">
<link rel="shortcut icon" href="<c:url value='/assets/ico/favicon.png'/>">
</head>

<body>

	<!-- Part 1: Wrap all page content here -->
	<div id="wrap">

		<!-- Begin page content -->
<!-- 		<div class="container"> -->
		<div>
			<div class="page-header close" >
				<h1></h1>
				<p class="lead"></p>
			</div>
			
			<div class="posts">
				<tiles:insertAttribute name="body" />
			</div>
			
		</div>

		<div id="push"></div>
	</div>

	<!-- <div id="footer" >
		<div class="container">
			<p class="muted credit">
				SpdSample
			</p>
		</div>
	</div> -->
	<script type="text/javascript">
		var host = '<%=request.getContextPath()%>';
	</script>
	<script src="<c:url value='/assets/js/loansys/compang.js'/>"></script>
</body>
</html>
