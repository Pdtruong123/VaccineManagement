$(document).ready(function () {
    $('#table-IR').DataTable({
        searching: true,
        ordering: true,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
    $('#news-tb').DataTable({
        searching: true,
        ordering: false,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    })
<<<<<<< HEAD
    $('#table-TS').DataTable({
=======
    $('#table-VC').DataTable({
>>>>>>> baa3ec6d9c08972b00430883da14f66327a862a4
        searching: true,
        ordering: false,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
<<<<<<< HEAD
=======
    $('#table-report').DataTable({
        searching: false,
        ordering: true,
        lengthMenu: [[5, 10,15, 20, 50, -1], [5, 10,15, 20, 50, "All"]]
    });
>>>>>>> baa3ec6d9c08972b00430883da14f66327a862a4
});
