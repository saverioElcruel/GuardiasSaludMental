const tableroPpal = document.querySelector("#tableroPpal");
const mensaje = document.querySelector("#mensaje");

const celdas = ["", "", "", "", "", "", "", "", ""];
let marca = "cruz";
mensaje.textContent = "Cruz empieza";

function crearTablero(tableroId) {
  const tablero = document.querySelector(`#${tableroId}`);
  celdas.forEach((_celda, index) => {
    const celda = document.createElement("div");
    celda.classList.add("casilla");
    celda.id = index;
    celda.addEventListener("click", agregarMarca);
    tablero.appendChild(celda);
  });
}

function crearTableros() {
  for (let i = 0; i <= 8; i++) {
    crearTablero(`t${i}`);
  }
}

crearTableros();

function estaCompleto(tablero) {
  const casillas = tablero.querySelectorAll(".casilla");
  return [...casillas].every((casilla) => casilla.querySelector(".cruz") || casilla.querySelector(".círculo"));
}

function agregarMarca(e) {
  const marcaForma = document.createElement("div");
  marcaForma.classList.add(marca);
  e.target.append(marcaForma);
  
  const celdaId = parseInt(e.target.id);

  const tableros = document.querySelectorAll(".tablero");

  tableros.forEach((tablero) => tablero.classList.remove("tablero-activo"));

  const tableroTarget = document.getElementById("t"+celdaId)

  const tablerosInTarget = [];

  tableros.forEach((tablero)=>{
    if(tablero.id!=tableroTarget.id){
      tablerosInTarget.push(tablero);
    }
  })

  if(estaCompleto(tableroTarget)){
    tablerosInTarget.forEach((tablero)=>{
      tablero.classList.add("tablero-activo");
      const casillas = tablero.querySelectorAll(".casilla");
      casillas.forEach((casilla)=>{
        casilla.addEventListener("click", agregarMarca);
      })
    })
  }else{

    tableros.forEach((tablero)=>{
      if (tablero.id.includes(celdaId)) {
        tablero.classList.add("tablero-activo");
        const casillas = tablero.querySelectorAll(".casilla");
        casillas.forEach((casilla) => {
        casilla.addEventListener("click", agregarMarca);
      });
    }else {
      const casillas = tablero.querySelectorAll(".casilla");
      casillas.forEach((casilla) => {
        casilla.removeEventListener("click", agregarMarca);
      });
      tablero.classList.add("tablero-inactivo");
    }
    
  })

  }
  
  marca = marca === "círculo" ? "cruz" : "círculo";
  let posicion = "";
  switch(e.target.id){
    case "0":
      posicion="de la esquina superior izquierda"
      break;
    case "1":
      posicion="de arriba al medio"
      break;
    case "2":
      posicion="de la esquina superior derecha"
      break;
    case "3":
      posicion="de la izquierda al medio"
      break;
    case "4":
      posicion="del centro"
      break;
    case "5":
      posicion="de la derecha al medio"
      break;
    case "6":
      posicion="de la esquina inferior izquierda"
      break;
    case "7":
      posicion="de abajo al medio"
      break;
    case "8":
      posicion="de la esquina inferior derecha"
      break;
  }
  

  mensaje.textContent = "Es ahora, " + marca + " juega";
  
  e.target.removeEventListener("click", agregarMarca);

  chequearPuntaje();
}

const cruzGanados=[];
const circuloGanados = [];

function buscarGanadorGlobal() {
    const tablerosGanadores = [
      [0, 1, 2], [3, 4, 5], [6, 7, 8],
      [0, 3, 6], [1, 4, 7], [2, 5, 8],
      [0, 4, 8], [2, 4, 6]
    ];

    const cruzGanaGlobalmente = tablerosGanadores.some(combinacion => combinacion.every(boardNum => cruzGanados.includes(boardNum)));
    const circuloGanaGlobalmente = tablerosGanadores.some(combinacion => combinacion.every(boardNum => circuloGanados.includes(boardNum)));

    if (cruzGanaGlobalmente) {
        mensaje.textContent = "¡Cruz gana globalmente!";
    } else if (circuloGanaGlobalmente) {
        mensaje.textContent = "¡Círculo gana globalmente!";
    }
}

function chequearPuntaje() {
  const tableroGanador = [
    [0, 1, 2], [3, 4, 5], [6, 7, 8],
      [0, 3, 6], [1, 4, 7], [2, 5, 8],
      [0, 4, 8], [2, 4, 6]
  ];
  
  for (let i = 0; i <= 8; i++) {
    const casillasTablero = document.querySelectorAll(`#t${i} .casilla`);
    for (const combinacion of tableroGanador) {
      const cruzGana = combinacion.every(
        (celda) => casillasTablero[celda]?.firstChild?.classList.contains("cruz")
      );
      const circuloGana = combinacion.every(
        (celda) =>
          casillasTablero[celda]?.firstChild?.classList.contains("círculo")
      );

      if (cruzGana) {
        mensaje.textContent = `¡Cruz gana en el tablero ${i}!`;
        casillasTablero.forEach((casilla) =>
          casilla.removeEventListener("click", agregarMarca)
        );
        cruzGanados.push(i);
        buscarGanadorGlobal();
        reiniciarTablero(i, "cruz");
        return;
      }

      if (circuloGana) {
        mensaje.textContent = `¡Círculo gana en el tablero ${i}!`;
        casillasTablero.forEach((casilla) =>
          casilla.removeEventListener("click", agregarMarca)
        );
        circuloGanados.push(i);
        buscarGanadorGlobal();
        reiniciarTablero(i, "círculo");
        return;
      }
    }
  }
}

function reiniciarTablero(tableroId, ganador) {
  const tablero = document.querySelector(`#t${tableroId}`);
  const marcaGrande = document.createElement("div");
  if (ganador === "cruz") {
    marcaGrande.classList.add("cruzGanadora");
  } else if (ganador === "círculo") {
    marcaGrande.classList.add("círculoGanador");
  }
  tablero.innerHTML = "";
  tablero.appendChild(marcaGrande);
}

