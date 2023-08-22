/*
def is_valid_state(state):
    # check if it is a valid solution
    return True

def get_candidates(state):
    return []

def search(state, solutions):
    if is_valid_state(state):
        solutions.append(state.copy())
        # return

    for candidate in get_candidates(state):
        state.add(candidate)
        search(state, solutions)
        state.remove(candidate)

def solve():
    solutions = []
    state = set()
    search(state, solutions)
    return solutions

/*
 * @param {number[]} nums
 * @return {number[][]}
*/

/*
function subsets(nums) {
    let list = [];
    backtrack(list, [], nums, 0);
    return list;
}

function backtrack(list , tempList, nums, start){
	// cloning an array 
    // (ES6) - [...tempList] 
	// (ES5) - JSON.parse(JSON.stringify(tempList)) ;   
    list.push([...tempList]);
    for(let i = start; i < nums.length; i++){
        tempList.push(nums[i]);                   // choose
        backtrack(list, tempList, nums, i + 1);   // explore
        tempList.pop();                           // unchoose
    }
}
*/
/*
function nGuardias(n){
    let guardias = [];
    asignarGuardia(guardias, [], n, 0);
    
    console.log(`guardias: ${guardias}`);
    return guardias;
}
function asignarGuardia(guardias,candidatos,n,inicio){
    guardias.push(...candidatos);

    for(let i = inicio; i < n.length; i++){
        candidatos.push(n[i]);                   // choose
        asignarGuardia(guardias, candidatos, n, i + 1);   // explore
        candidatos.pop();                           // unchoose
    }

    
console.log(`candidatos: ${candidatos}`);
}

console.log(nGuardias(64));
*/

const docs = [{ id: 0,
                name: "Chapatin",
                dispDia: "LMXJVSD",
                dispNoche: "LMXJVSD",
                trabaja24: true,
                comienzoLicencia: new Date("2023-08-23T10:00:00"),
                finLicencia: new Date("2023-08-30T11:30:00")},
                {id: 1,
                name: "Menguele",
                dispDia: "SD",
                dispNoche: "SD",
                trabaja24: false,
                comienzoLicencia: new Date("2023-09-1T10:00:00"),
                finLicencia: new Date("2023-09-10T11:30:00")},
                {id: 2,
                name: "Manosanta",
                dispDia: "VSD",
                dispNoche: "VSD",
                trabaja24: false,
                comienzoLicencia: new Date("2023-08-25T10:00:00"),
                finLicencia: new Date("2023-08-26T11:30:00")}];

function nGuardias(n){
    let guardias = new Array(n).fill(" ");
    const nombreDia = ["D", "L", "M", "X", "J", "V", "S"];

    const guardiaInicio = new Date("2023-08-22T11:30:00");
    const diaSemana = guardiaInicio.getDay();
    
    let guardia = {id:0, fecha: new Date(), turno: "dia", dia: nombreDia[diaSemana]};
    return asignarGuardia(guardia,guardias,n)
}

function asignarGuardia(guardia,guardias,n){
    if (guardia.id == n){
        
    console.log(guardias);
        return 1;
    }else{
        total_soluciones = 0;
        for (let i=0; i<docs.length; i++){
            if (esValido(guardia,docs[i],guardias)){
                guardias[guardia]=docs[i].name;
                guardiaSiguiente = siguienteGuardia(guardia);
                total_soluciones+= asignarGuardia(guardiaSiguiente,guardias,n);
            }
        };
        return total_soluciones;
    }
}

function esValido(guardia,doc){
        //Acá irían las condiciones. El bucle recorre las guardias que hay para atrás
        // DISPONIBILIDAD / NO LICENCIA / TOPE FINDE O FERIADO / CENTINELA / 

        let tieneDispo = guardia.turno=="dia"?dispDia():dispNoche();

        if (!tieneDispo) {
            return false;
        }

    return true;
}

function dispDia(doc,guardia){
    doc.dispDia.includes(guardia.fecha)
}
function dispNoche(doc,guardia){
    doc.dispNoche.includes(guardia.fecha)
}

function siguienteGuardia(guardia) {
    const siguienteFecha = new Date(guardia.fecha);
    if (guardia.turno === "dia") {
        siguienteFecha.setHours(23, 59, 59); // Set to end of day
    } else {
        siguienteFecha.setDate(siguienteFecha.getDate() + 1); // Next day
        siguienteFecha.setHours(0, 0, 0); // Set to beginning of day
    }
    
    const siguienteTurno = guardia.turno === "dia" ? "noche" : "dia";
    const siguienteId = guardia.id+1;
    
    return [{ id: siguienteId, fecha: siguienteFecha, turno: siguienteTurno }];
}

var resultado = nGuardias(14);

console.log(resultado);