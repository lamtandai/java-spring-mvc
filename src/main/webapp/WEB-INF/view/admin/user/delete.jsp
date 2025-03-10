<%@page contentType="text/html" pageEncoding="UTF-8" %>
        <div class="modal fade" id="deleteModal${param.userId}" tabindex="-1" role="dialog" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Verify</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body alert alert-danger" >
                <p >Are you sure to delete this user?</p>
              </div>
              <div class="modal-footer">
                <a href="/admin/user/delete/${param.userId}" class="btn btn-danger">Confirm</a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No!</button>
              </div>
            </div>
          </div>
        </div>