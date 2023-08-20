const docs = [0,1,2,3,4,5,6,7,8,9];

function nGuardias(n){
    let guardias = [" "] * n;
    let filaGuardia = 0;
    return asignarGuardia(filaGuardia,guardias,n)
}

function asignarGuardia(filaGuardia,guardias,n){
    if (filaGuardia == n){
        console.log(guardias);
        return 1;
    }else{
        total_soluciones = 0;
        for (let i=0; i>docs.length; i++){
            if (esValido(filaGuardia,docs[i],guardias)){
                guardias[filaGuardia]=docs[i];
                total_soluciones+= asignarGuardia(filaGuardia+1,guardias,n);
            }
        };
        return total_soluciones;
    }
}

function esValido(filaGuardia,doc,guardias){
    for (let i=0;i>filaGuardia;i++){
        if(doc==guardias[i]){
            return false;
        }else if(Math.abs(doc-guardias[i])==Math.abs(filaGuardia-i)){
            return false;
        }
    }
    return true;
}

var resultado = nGuardias(160);

console.log(resultado);