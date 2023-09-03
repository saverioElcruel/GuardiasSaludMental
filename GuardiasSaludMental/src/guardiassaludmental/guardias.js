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

    
    // FUNCION 1 DEL BACKTRACKING

    function nGuardia(n){
        const docs = [{ 
            id:0,
            nombre:"Hector",
            dispDia:"LMXJVSD",
            dispNoche: "LMXJVSD",
            trabaja24: true,
            comienzoLicencia: "2023-07-01",
            finLicencia: "2023-07-15"
            },{
            id:1,
            nombre: "Maru",
            dispDia: "LV",
            dispNoche: "SD",
            trabaja24: false,
            comienzoLicencia: "2023-09-01",
            finLicencia: "2023-09-10"
            },{
            id:2,
            nombre: "Lau S.",
            dispDia: "LMXJVSD",
            dispNoche: "MS",
            trabaja24: true,
            comienzoLicencia: "2023-09-01",
            finLicencia: "2023-09-10"
            },{
            id:3,
            nombre: "Rodo",
            dispDia: "LMXJVSD",
            dispNoche: "LMXJVSD",
            trabaja24: true,
            comienzoLicencia: "2023-06-26",
            finLicencia: "2023-07-15"
            },{
            id:4,
            nombre: "Javier",
            dispDia: "LMXJSD",
            dispNoche: "LMSD",
            trabaja24: true,
            comienzoLicencia: "2023-06-16",
            finLicencia: "2023-06-21"
            },{
            id:5,
            nombre: "Flor",
            dispDia: "LMXJSD",
            dispNoche: "LMSD",
            trabaja24: false,
            comienzoLicencia: "2023-06-16",
            finLicencia: "2023-06-22"
            },{
            id:6,
            nombre: "Luisi",
            dispDia: "LXJSD",
            dispNoche: "D",
            trabaja24: false,
            comienzoLicencia: "2023-06-16",
            finLicencia: "2023-07-01"
            },{
            id:7,
            nombre: "Lucia",
            dispDia: "LVSD",
            dispNoche: "LMJSD",
            trabaja24: false,
            comienzoLicencia: "2023-09-16",
            finLicencia: "2023-10-01"
            },{
            id:8,
            nombre: "Lorena",
            dispDia: "MVS",
            dispNoche: "",
            trabaja24: false,
            comienzoLicencia: "2023-09-16",
            finLicencia: "2023-10-01"
            },{
            id:9,
            nombre: "Julia",
            dispDia: "VSD",
            dispNoche: "MXSD",
            trabaja24: true,
            comienzoLicencia: "2023-09-16",
            finLicencia: "2023-10-01"
            },{
            id:10,
            nombre: "Anto",
            dispDia: "LMXJVSD",
            dispNoche: "LMXJVSD",
            trabaja24: false,
            comienzoLicencia: "2023-09-16",
            finLicencia: "2023-10-01"
            }];
        const guardiaInicio = new Date("2023-06-15");
        const diaSemana = guardiaInicio.getDay();
        const nombreDia = ["D", "L", "M", "X", "J", "V", "S"];
        const guardia = {id:0, fecha: new Date(guardiaInicio), turno: "dia", dia: nombreDia[diaSemana], doc: " "};
    
        return asignarGuardia(docs,guardia,60)
    }

    function asignarGuardia(docs,guardia,n){
        let guardias = [];
        let candidatos = [];
        function recursive(docs,i){
            if(i===docs.length){
                return resultado.push([...candidatos]);
            }
            candidatos.push(guardias[i]);
            recursive(docs,guardias,i+1)

            candidatos.pop();
            recursive(guardias,i+1);
        }
        recursive(guardias,0)
    }
//     let guardias = 
//     let guardia = guardiaPrimera;
    
//     // console.log(guardias);

//     // La función recursiva se llama desde una función que no es recursiva y desde sí misma
//     return asignarGuardia(guardia,guardia,n);
// }

// FUNCION 2 DEL BACKTRACKING
function asignarGuardia(inicio,guardia,fin) {
    if (fin < inicio) {
        
        return {};
    } else {
        guardia=siguienteGuardia(guardia);
        const guardias = asignarGuardia(inicio,guardia,fin-1);
        console.log(guardias);
        for (const doc of docs) {
            if (esValido(guardia, doc)) {
                guardia.doc = doc.nombre;
                guardias[fin] = guardia;
                
            }
        }
        return guardias;
    }
}

// FUNCION 3 DEL BACKTRACKING
function esValido(guardia, doc) {
    let tieneDispo = 
        guardia.turno === "dia" ? 
            dispDia(doc, guardia.dia) 
            : 
            dispNoche(doc, guardia.dia);

        if (!tieneDispo) {
            return false;
        }
    return true;
}

function dispDia(doc, dia) {
    return doc.dispDia.includes(dia);
}

function dispNoche(doc, dia) {
    return doc.dispNoche.includes(dia);
}

function siguienteGuardia(guardia) {
    let siguienteFecha = new Date(guardia.fecha);

    if (guardia.turno === "noche") {
        siguienteFecha.setDate(siguienteFecha.getDate() + 1);
    }

    let siguienteTurno = guardia.turno === "dia" ? "noche" : "dia";
    let siguienteId = guardia.id + 1;

    let diaSemana = guardia.fecha.getDay();
    let nombreDia = ["D", "L", "M", "X", "J", "V", "S"];

    guardia = {id:siguienteId, fecha: siguienteFecha, turno: siguienteTurno, dia: nombreDia[diaSemana], doc: " "};
    
    return guardia;
}

asignarGuardia(1,guardiaPrimera,60);
