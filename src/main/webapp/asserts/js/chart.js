window.onload = function() {
    chartReport();

};
function chartReport(){
    var abc=$("#year-select").val();
    $.ajax({
        url: '/chart/injection-value?year='+abc,
        type: 'GET',
        dataType: 'JSON',
        success: function (res) {
            var yValues=[];

            yValues = res;
            var xValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

            var barColors = "#88CDF6";

            new Chart("myChart", {
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



