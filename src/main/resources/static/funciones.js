

/*function eliminar(id){
	
            Swal.fire({//con este codigo llamamos a sweetalert2
                title:'¿Esta seguro de borrar el registro: '+id+" ?",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#d33',
                cancelButtonColor: '#3085d6',
                confirmButtonText: 'Borrar'
            }).then((result) => {//si el result se confirma va a borrarMovil
                if(result.value) {
                   //this.borrarMovil(id);
                   $.ajax({
						url:"/eliminar/"+id,
						success, function(res){
							console.log(res);
						}
					}); 
                   //le mostramos un mensaje sobre la eliminacion
                   Swal.fire(
                       'Eliminado',
                       'El registro ha sido borrado.',
                       'success'
                   )
                }
                
            });
        
}
*/

function eliminar(id){
			Swal.fire({
		  title: '¿Estas seguro de eliminarlo?',
		  text: "Una vez borrado no se podra recuperar",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Si, borrar!',
		  cancelButtonText: 'No, cancelar',
		  reverseButtons: true
		}).then((ok) => {
		  if (ok.isConfirmed) {
			$.ajax({
				url:"/eliminar/"+id,
				success: function(res){
					console.log(res);
				}
			});
			Swal.fire(
		      'Borrado!',
		      'El registro a sido borrado.',
		      'success'
		    ).then((ok)=> {
				
				if(ok){
					location.href="/listar";
				}
			});
		    
		  } else  {
		    Swal.fire(
		      'Cancelado',
		      'El registro no se a borrado.',
		      'error'
		    )
		  }
		});
}


