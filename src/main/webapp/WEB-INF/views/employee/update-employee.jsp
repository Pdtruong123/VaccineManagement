<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/VaccineType.js"></script>
<script src="${pageContext.request.contextPath}/js/ValidateEmployee.js"></script>

<div>
	<div class="h5 mt-3 text-center text-dark font-weight-bold mb-3"
		style="color: black">UPADTE EMPLOYEE</div>

	<div class="card mx-3">
		<div class="card-body">

			<form:form
				action="${pageContext.request.contextPath}/employee/update"
				method="post" modelAttribute="employee"
				enctype="multipart/form-data" id="employee-form">


				<div class="form-row">
					<div class="form-group">
						<form:input type="hidden" class="form-control w-50" id="id" path="id"
							readonly="true" />
					</div>


					<div class="form-group col-sm-5">
						<label class="font-weight-bold" for="name">Employee name<span
							class="text-danger">(*):</span></label>
						<form:input class="form-control" type="text"
							placeholder="Nguyen Van A" id="name" path="employeeName" />
					</div>
					<div class="form-group col-sm-2"></div>


					<div class="form-group col-sm-5">
						<label class="font-weight-bold" for="gender">Gender </label>
						<div class="form-inline">
							<i class="fa-regular fa-face-meh-blank"></i>
							<div class="gender d-flex justify-content-evenly border rounded">
								<div class="form-check form-check-inline">
									<form:radiobutton path="gender" id="gender" value="0" />
									Male

								</div>
								<div class="form-check form-check-inline">
									<form:radiobutton path="gender" id="gender" value="1" />
									Female
								</div>
							</div>

						</div>
					</div>


					<div class="form-group col-sm-4">
						<label class="font-weight-bold" for="dateOfBirth">Date Of
							Birth<span class="text-danger">(*):</span>
						</label>
						<form:input class="form-control" type="date"
							placeholder="12/12/1999" id="dateOfBirth" path="dateOfBirth" />
					</div>

					<div class="form-group col-sm-4">
						<label class="font-weight-bold" for="phone">Phone<span
							class="text-danger">(*):</span></label>
						<form:input class="form-control" type="phone"
							placeholder="0123456789" id="phone" path="phone" />
					</div>

					<div class="form-group col-sm-4">
						<label class="font-weight-bold" for="address">Address<span
							class="text-danger">(*):</span></label>
						<form:input class="form-control" type="text"
							placeholder="17 Duy Tan" id="address" path="address" />
					</div>


					<div class="form-group col-sm-4">
						<label class="font-weight-bold" for="email">Email<span
							class="text-danger">(*):</span></label>
						<form:input class="form-control" type="email" placeholder=""
							id="email" path="email" />
					</div>

					<div class="form-group col-sm-4">
						<label class="font-weight-bold" for="workingPlace">Working
							Palace:</label>
						<form:input class="form-control" type="text"
							placeholder="Hong Ngoc" id="workingPlace" path="workingPlace" />
					</div>


					<div class="form-group col-sm-4">
						<label class="font-weight-bold" for="position">Position:</label>
						<form:input class="form-control" type="text" id="position"
							path="position" placeholder="Doctor" />
					</div>
				</div>
		</div>

		<div class="form-group ">
			<label class="font-weight-bold">Image :</label>
			<div class="row">
				<div class="col-sm-1">
					<i class="fa-solid fa-image mt-2 h5"></i>
				</div>
				<div class="custom-file mb-3 ml-3 col-sm-5">
					<form:input type="file" class="custom-file-input" path="imageFile"
						accept="image/*" id="file-input" />
					<form:input type="hidden" class="custom-file-input_hidden"
						path="customFileInputHidden" />
					<label class="custom-file-label" for="customFile">Choose
						file</label>
				</div>
			</div>
			<div class="img-upload">

				<c:if test="${empty employee.imageUrl}">
					<span class="ml-5 text-danger text-img font-weight-bold">Not
						image founded !!!</span>
				</c:if>
				<img id="img-preview"
					src="${pageContext.request.contextPath}/img/imgemployee/${employee.imageUrl}" />
				<c:if test="${not empty employee.imageUrl}">
					<a class="btn btn-sm btn-danger ml-5 delete-img text-white">Delete</a>
				</c:if>

			</div>

		</div>



		<div class="form-button mt-4">
			<button class="btn btn-success mr-1" type="submit">Save</button>
			<button class="btn btn-primary mr-1" type="reset">Reset</button>
			<button class="btn btn-warning text-white" type="button">
				<a href="${pageContext.request.contextPath}/employee/list"
					class="text-white text-decoration-none">Cancel</a>
			</button>

			</form:form>
		</div>

	</div>
</div>
