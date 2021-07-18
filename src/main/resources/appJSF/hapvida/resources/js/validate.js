
function mascara(o,f){
	v_obj=o;
    v_fun=f;
    setTimeout("execmascara()",1);
}
        
function execmascara(){
	v_obj.value=v_fun(v_obj.value);
}
        
function numero(v){
	return v.replace(/\D/g,"");
}

function double(v){
	var b = v.substring(v.length-1,v.length);
	v=v.replace(/[^\d\.]/g, "");
	var e = v.substring(0,v.length-1);	
	if(e.indexOf(".")>-1) {
		if(b.indexOf(".")>-1) v=e;		
	}
	return v;
}
        
function telefone(v){
	v=v.replace(/\D/g,"");                          
    v=v.replace(/^(\d\d)(\d)/g,"($1)$2");    
    if(v.length >= 13) {
    	v=v.replace(/(\d{5})(\d)/,"$1-$2");
    	
    }else{
    	v=v.replace(/(\d{4})(\d)/,"$1-$2");
    }
    return v;
}

function cpf(v){
	v=v.replace(/\D/g,"");                                   
	v=v.replace(/(\d{3})(\d)/,"$1.$2");         
	v=v.replace(/(\d{3})(\d)/,"$1.$2");                                                                                                 
	v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2"); 
	return v;
}
        
function cep(v){
	v=v.replace(/D/g,"");                            
    v=v.replace(/^(\d{5})(\d)/,"$1-$2"); 
	return v;
}

function cnpj(v){
	v=v.replace(/\D/g,"");                              
	v=v.replace(/^(\d{2})(\d)/,"$1.$2");      
	v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3"); 
	v=v.replace(/\.(\d{3})(\d)/,".$1/$2");              
	v=v.replace(/(\d{4})(\d)/,"$1-$2");                        
	return v;
}

function data(v){
    v=v.replace(/\D/g,""); 
    v=v.replace(/(\d{2})(\d)/,"$1/$2"); 
    v=v.replace(/(\d{2})(\d)/,"$1/$2"); 
    return v;
}


function hora(v){
	v=v.replace(/\D/g,""); 
	v=v.replace(/(\d{2})(\d)/,"$1:$2");  
	return v;
}