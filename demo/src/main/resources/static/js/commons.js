function cmmFormModify(_form, url, success) {
	_ajaxFormSave('수정', _form, url, success);
}

/*  
function _ajaxFormSave(text, _form, url, success = false) {
	var formdata = new FormData();
	var $form = $(_form);
	var msgs = [];
	$form.find('.custom-file input[type=file]').each(function() {
		var file = $(this)[0].files[0];
		if(checkFileSize(file)) {
			formdata.append($(this)[0].name, $(this)[0].files[0]);
		}
		else {
			msgs.push('[' + file.name + '(' + file.size + ' byte)]')
		}
	});
	if(msgs.length > 0) {
		bsAlert('파일 용량 확인<br/>' + msgs.join('<br/>'));
	}
	else {
		bsConfirm(text + '하시겠습니까?', function() {
			var data = $form.serializeArray();
			data.forEach(function(item) {
				formdata.append(item.name, item.value);
			});
			$.ajax({
				url: url,
				method: 'post',
				dataType: 'json',
				data: formdata,
				processData: false,
				contentType: false,
				success: function(data, status) {
					if(success) { 
						success(data);
					}
					else {
						if(data.header.responseCode == '200') {
							bsFormAlert(text + ' 성공', function() {
								$('.btn-list').click();
							});
						}
						else {
							bsAlert(data.header.responseMsg);
						}
					}
				},
				error: function(jqXHR) {
					if(typeof jqXHR.responseJSON == 'object') {
						bsAlert(text + ' 실패<br/>(' + jqXHR.responseJSON.header.responseMsg + ')');
					}
					else {
						bsAlert(text + ' 실패');
					}
				}
			});
		});
	}
}
*/

function bsFormAlert(msg, callback) {
	var $m = _createModal2(msg);
	$m.find('.btn-confirm').off('click').on('click', callback).show();
	$m.find('.modal-body').html(msg);
	$m.modal('show');
	$m.on('hide.bs.modal', function() {
		$(this).remove();
	});
	return $m;
}

function _createModal2(msg) {
	var html = '';
	html += '<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="false">';
	html += '	<div class="modal-dialog" role="document">';
	html += '		<div class="modal-content">';
	html += '			<div class="modal-header">';
	html += '				<h6 class="modal-title">알림</h6>';
	html += '				<button class="close btn-reload" type="button" data-dismiss="modal" aria-label="Close">';
	html += '					<span aria-hidden="true">×</span>';
	html += '				</button>';
	html += '			</div>';
	html += '			<div class="modal-body">' + msg + '</div>';
	html += '			<div class="modal-footer">';
	html += '				<button class="btn btn-secondary btn-confirm" type="button" data-dismiss="modal">목록</button>';
	html += '				<button class="btn btn-primary btn-reload" type="button" onclick="location.reload()">닫기</button>';
	html += '			</div>';
	html += '		</div>';
	html += '	</div>';
	html += '</div>';
	var $m = $(html);
	$('body').append($m);
	return $m;
}

function bsAlert(msg) {
	var $m = _createModal(msg);
	$m.find('.btn-confirm').off('click').hide();
	$m.find('.modal-body').html(msg);
	$m.modal('show');
	$m.on('hide.bs.modal', function() {
		$(this).remove();
	});
	return $m;
}

function _createModal(msg) {
	var html = '';
	html += '<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="false">';
	html += '	<div class="modal-dialog" role="document">';
	html += '		<div class="modal-content">';
	html += '			<div class="modal-header">';
	html += '				<h6 class="modal-title">알림</h6>';
	html += '				<button class="close" type="button" data-dismiss="modal" aria-label="Close">';
	html += '					<span aria-hidden="true">×</span>';
	html += '				</button>';
	html += '			</div>';
	html += '			<div class="modal-body">' + msg + '</div>';
	html += '			<div class="modal-footer">';
	html += '				<button class="btn btn-secondary btn-close" type="button" data-dismiss="modal">닫기</button>';
	html += '				<button class="btn btn-primary btn-confirm" type="button" data-dismiss="modal">확인</button>';
	html += '			</div>';
	html += '		</div>';
	html += '	</div>';
	html += '</div>';
	var $m = $(html);
	$('body').append($m);
	return $m;
}

function bsConfirm(msg, callback) {
	var $m = _createModal(msg);
	$m.find('.btn-confirm').off('click').on('click', callback).show();
	$m.find('.modal-body').html(msg);
	$m.modal('show');
	$m.on('hide.bs.modal', function() {
		$(this).remove();
	});
	return $m;
}

