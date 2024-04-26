<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<main class="d-flex align-items-center  text-dark banner-background"
		style="height: 70vh">
		<div class="container">
			<div class="row">
				<div class="col-md-8 offset-md-2">
					<div class="card">
						<div class="card-header  primary-header text-white text-center">
							<p>Login</p>
						</div>

						<div class="card-body">

							<form action="Login" method="post">

								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> <input
										required type="email" class="form-control" name="email"
										id="exampleInputEmail1" aria-describedby="emailHelp"
										placeholder="Enter email"> <small id="emailHelp"
										class="form-text text-muted">We'll never share your
										email with anyone else.</small>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										required type="password" class="form-control" name="password"
										id="exampleInputPassword1" placeholder="Password">
								</div>

								<div class="form-group row justify-content-center">
									<div class="col-auto">
										<input type="radio" name="person" value="Admin" required> Admin
									</div>
									<div class="col-auto">
										<input type="radio" name="person" value="Doctor" required>
										Doctor
									</div>
									<div class="col-auto">
										<input type="radio" name="person" value="Patient" required>
										Patient
									</div>
								</div>


								<div class="container text-center">
									<button type="submit" class="btn btn-primary primary-header">Login</button>
								</div>

							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

</body>
</html>