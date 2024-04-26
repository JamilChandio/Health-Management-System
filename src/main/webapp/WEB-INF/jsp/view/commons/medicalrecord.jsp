<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Find Medical Record</title>
</head>
<body>
	<div class="container">
		<h2 class="text-center mb-4">Find Medical Record</h2>
		<form action="GetRecord" method="post">
			<div class="form-group">
				<label for="medicalRecordNumber">Medical Record Number</label> <input
					type="number" class="form-control" name="id" id="medicalRecordNumber"
					placeholder="Enter Medical Record Number" required="required">
			</div>
			<button type="submit" class="btn btn-primary btn-block" style="width: 80px;">Find</button>
		</form>
	</div>
</body>
</html>
