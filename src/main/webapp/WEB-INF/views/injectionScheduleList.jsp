<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">Injection Schedule</div>
    <div class="card mx-3">
        <div class="card-body">
            <div class="row">
                <div class="col-sm-3 form-inline">
                    <span>Show</span>
                    <select class="form-select mx-2 border-right-0 border-top-0 border-left-0"
                            id="inlineFormCustomSelect">
                        <option selected></option>
                        <option value="1">5</option>
                        <option value="2">10</option>
                        <option value="3">15</option>
                    </select>
                    <span>entities</span>
                </div>
                <div class="col-sm-6"></div>
                <div class="col-sm-3">
                    <form action="#">
                        <div class="input-group ">
                            <input type="search"
                                   class="dataSearch form-control border-right-0 border-top-0 border-left-0 form-select"
                                   placeholder="Search" aria-label="Search" aria-describedby="search-addon" onchange="searchOnchange(this.value)"/>
                            <button class="input-group-text border-0 bg-white" id="search-addon">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="mt-3">
                <table class="table table-bordered">
                    <thead>
                    <tr class="bg-info text-white text-center">
                        <th>Vaccine</th>
                        <th>Time</th>
                        <th>Place</th>
                        <th>Status</th>
                        <th>Note</th>
                    </tr>
                    </thead>
                   <tbody id="bodyList">

                </tbody>
                </table>
            </div>
            <div class="row mt-4">
                <div class="col-sm-3">
                    <span>Showing 1 to 5 of 12 entities</span>
                </div>
                <div class="col-sm-6"></div>
                <div class="col-sm-3">
                    <nav aria-label="Page">
                        <ul class="pagination">
                            <li class="page-item-pre">
                                <a class="page-link pagination-list"
                                   href="#"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link pagination-list" href="#">1</a></li>
                            <li class="page-item"><a class="page-link pagination-list" href="#">2</a></li>
                            <li class="page-item"><a class="page-link pagination-list" href="#">3</a></li>
                            <li class="page-item-next">
                                <a class="page-link pagination-list" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="">
                <a class="btn btn-sm btn-success" href="#">New Injection Schedule</a>
                <a class="btn btn-sm btn-warning ml-2" href="#">Update Injection Schedule</a>
            </div>
        </div>
    </div>
<script src="${pageContext.request.contextPath}/js/InjectionScheduleApi.js"></script>
