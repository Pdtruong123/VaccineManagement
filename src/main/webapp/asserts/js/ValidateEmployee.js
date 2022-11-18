// $(document).ready(function () {
//
//     $("#employee-form").validate({
//         rules: {
//             id: {
//                 required: true,
//                 minlength: 3,
//                 maxlength: 25
//             },
//             employeeName: {
//                 required: true,
//                 maxlength: 3,
//                 minlength: 25
//             },
//
//             dateOfBirth: {
//                 required: true
//             },
//             gender: {
//                 required: true,
//             },
//
//             address: {
//                 required: true,
//                 maxlength: 100
//             },
//             phone: {
//                 required: true,
//                 maxlength: 12
//             },
//             workingPlace: {
//                 required: true,
//                 minlength: 5,
//                 maxlength: 20,
//             },
//             position: {
//                 required: true,
//                 minlength: 5,
//                 maxlength: 20,
//
//             },
//             email: {
//                 required: true,
//                 maxlength: 25
//             },
//
//
//         },
//         messages: {
//             id: {
//                 required: "Please input your employee ID",
//                 minlength: "Full name only accept 3-25 characters",
//                 maxlength: "Full name only accept 3-25 characters"
//             },
//             employeeName: {
//                 required: "Please input your Employee Name",
//                 minlength: "Identity card must be 3-25 numbers",
//                 maxlength: "Identity card must be 3-25 numbers"
//             },
//             dateOfBirth: {
//                 required: "Please input your birthday",
//             },
//             gender: {
//                 required: "Please choose your gender",
//             },
//
//             address: {
//                 required: "Please input your address",
//                 maxlength: "Address too long"
//             },
//             phone: {
//                 required: "Please input your phone number",
//
//             },
//             email: {
//                 required: "Please input your email",
//
//             },
//
//             workingPlace: {
//                 required: "Please input your workingPlace",
//                 minlength: "workingPlace have at least 5 characters ",
//                 maxlength: "workingPlace can't more than 20 characters"
//             },
//             position: {
//                 required: "Please input your position",
//                 equalTo: "position have at least 5 characters",
//                 maxlength: "position can't more than 25 characters"
//             },
//
//         },
//     })
//
// });
//
// $.validator.addMethod("email", function (value, element, params) {
//     let regex = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
//     return regex.test(value) === params;
// }, "Wrong email");
// $.validator.addMethod("phone", function (value, element, params) {
//     let regex = new RegExp("^[0]{1}\\d{12}$");
//     return regex.test(value) === params;
// }, "Wrong phone number");
//
// // function ValidateDOB() {
// //     if (regex.test(dateString)) {
// //         var parts = dateString.split("/");
// //         var dtDOB = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
// //         var dtCurrent = new Date();
// //         lblError.innerHTML = "Eligibility 18 years ONLY."
// //         if (dtCurrent.getFullYear() - dtDOB.getFullYear() < 18) {
// //             return false;
// //         } else {
// //             lblError.innerHTML = "Enter date in dd/MM/yyyy format ONLY."
// //             return false;
// //         }
// //     }}