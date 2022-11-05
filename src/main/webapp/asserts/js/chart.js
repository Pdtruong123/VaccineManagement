window.onload = function() {
    chartReport();

};
function chartReport(){
    var xValues = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    var yValues = [0.5, 1, 1, 0.5, 2, 3, 0.7, 1, 4, 3, 2.5, 3];
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
}

