window.onload = function() {
    chartInject();
    chartVaccine();
    chartCustomer();

};
function chartInject(){
    var year = $("#year-select").val();
    $.ajax({
        url: '/chart/injection-value?year='+year,
        type: 'GET',
        dataType: 'JSON',
        success: function (res) {
            var yValues=[];

            yValues = res;
            var xValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
            var barColors = "#88CDF6";
            new Chart("chartInject", {
                type: "bar",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: barColors,
                        data: yValues
                    }]
                },
                options: {
                    legend: {display: false},
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }],
                    }
                }
            });
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function chartVaccine(){
    var year = $("#year-select").val();
    $.ajax({
        url: '/chart/vaccine-value?year='+year,
        type: 'GET',
        dataType: 'JSON',
        success: function (res) {
            var yValues=[];
            yValues = res;
            var xValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
            var barColors = "#88CDF6";
            new Chart("chartVaccine", {
                type: "bar",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: barColors,
                        data: yValues
                    }]
                },
                options: {
                    legend: {display: false},
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }],
                    }
                }
            });
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function chartCustomer(){
    var year = $("#year-select").val();
    $.ajax({
        url: '/chart/customer-value?year='+year,
        type: 'GET',
        dataType: 'JSON',
        success: function (res) {
            var yValues=[];
            yValues = res;
            var xValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
            var barColors = "#88CDF6";
            new Chart("chartCustomer", {
                type: "bar",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: barColors,
                        data: yValues
                    }]
                },
                options: {
                    legend: {display: false},
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }],
                    }
                }
            });
        },
        error: function (err) {
            console.log(err);
        }
    })
}



