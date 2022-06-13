<%@page import="java.util.List"%>
<%@page import="lt.bit.models.Message"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<jsp:include page="partials/head.jsp"></jsp:include>



<div class="container main-content" >

	<div class="row mt-5" >
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">Message board</div>
				<div class="card-body">
					<table class="table">
						<thead>
							<tr>
								<th>Db Id</th>
								<th>Who</th>
								<th>When</th>
								<th>Content</th>
							</tr>
						</thead>
						 
						<tbody>
						   <% for (Message m:  (List<Message>) request.getAttribute("messages") ){ %>
							<tr>
								<td><%=m.getId()%></td>
								<td><%=m.getUsername()%></td>
								<td><%=m.getDateCreated()%></td>
								<td><%=m.getContent() %></td>
							</tr>
							<%} %>
						</tbody>
						
					</table>
					<form class="form form-control" action="" method="POST">
						<div class="form-group">
						    <label for="CONTENT">What's on your mind?</label>
						    <textarea class="form-control"name="CONTENT" rows="4"></textarea>
	  					</div>
	  					<div class="col-md-12">
	  						<button class="btn btn-success" type="submit">Post</button>
	  					</div>
  					</form>
				</div>
			</div>
		</div>
	
	</div>
</div>
<jsp:include page="partials/foot.jsp"></jsp:include>

