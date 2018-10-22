<!-- Bootstrap Modal -->
<div class="modal fade" id="taskInfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <input type="hidden" id="taskInfoDialoTaskId"/>
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="taskInfoModalCenterTitle">Task Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Hello body</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="approve-btn">Approve</button>
        <button type="button" class="btn btn-warning">Disapprove</button>
        <button type="button" class="btn btn-secondary">Release</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $("#approve-btn").on("click", e => {
      alert($("#taskInfoDialoTaskId").val());
    });
</script>