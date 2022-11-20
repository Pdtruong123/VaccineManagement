$(document).ready(function () {
    $('#table-IR').DataTable({
        searching: true,
        ordering: true,
        order: [],
        columnDefs: [ {
            'targets': [0],
            'orderable': false,
        }],
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
    $('#news-tb').DataTable({
        searching: true,
        ordering: true,
        order: [],
        columnDefs: [ {
            'targets': [0],
            'orderable': false,
        }],
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    })

    $('#table-TS').DataTable({
        searching: true,
        ordering: true,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
    $('#table-VC').DataTable({

        searching: true,
        ordering: true,
        order: [],
        columnDefs: [ {
            'targets': [0],
            'orderable': false,
        }],
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });

    $('#table-report').DataTable({
        searching: false,
        ordering: true,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });

    $('#table-IC').DataTable({
        searching: true,
        ordering: true,
        order: [],
        columnDefs: [ {
            'targets': [0],
            'orderable': false,
        }],
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
    $('#employee-tb').DataTable({
        searching: true,
        ordering: true,
        order: [],
        columnDefs: [ {
            'targets': [0],
            'orderable': false,
        }],
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });

});


