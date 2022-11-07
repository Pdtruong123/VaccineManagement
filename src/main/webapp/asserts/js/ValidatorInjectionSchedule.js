$(document).ready(function (){
    $.validator.addMethod("validaDate",function (value,element) {
        var startDate=$('startDate').val();
        var endDate=$('endDate').val();

        var d1 = startDate.split('/');
        d1 = new Date(d1.pop(), d1.pop() - 1, d1.pop());

        var d2 = endDate.split('/');
        d2 = new Date(d2.pop(), d2.pop() - 1, d2.pop());
        return d2>d1;
    },"The end date must be greater than the start date");
    $('#form-Schedule').validate({
        rules:{
            startDate:{
                required:true
            },
            endDate:{
                required: true,
                validaDate:true
            },
            place:{
                required:true
            },
            note:{
                required:true
            }
        }
    })
})