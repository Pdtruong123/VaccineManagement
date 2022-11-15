$(document).ready(function () {
    $('#table-IR').DataTable({
        searching: true,
        ordering: false,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
    $('#news-tb').DataTable({
        searching: true,
        ordering: false,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    })
    $('#table-TS').DataTable({
        searching: true,
        ordering: false,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
});
