const tableroPpal = document.querySelector("#tableroPpal");
const mensaje = document.querySelector("#mensaje");

const celdas = ["", "", "", "", "", "", "", "", ""];
let marca = "cruz";
mensaje.textContent = "Cruz empieza";

function crearTablero(targetId) {
  const target = document.querySelector(`#${targetId}`);
  celdas.forEach((_celda, index) => {
    const celdaElemento = document.createElement("div");
    celdaElemento.classList.add("casilla");
    celdaElemento.id = index;
    celdaElemento.addEventListener("click", agregaMarca);
    target.appendChild(celdaElemento);
  });
}

function crearTableros() {
  for (let i = 0; i <= 8; i++) {
    crearTablero(`t${i}`);
  }
}

crearTableros();

function agregaMarca(e) {
  const marcaForma = document.createElement("div");
  marcaForma.classList.add(marca);
  e.target.append(marcaForma);
  
  const cellId = parseInt(e.target.id);

  const boardId = cellId;

  const allBoards = document.querySelectorAll(".tablero");
  allBoards.forEach((board) => board.classList.remove("active-board"));

  const activeBoard = document.querySelector("#t" + boardId);
  activeBoard.classList.add("active-board");

  marca = marca === "círculo" ? "cruz" : "círculo";
  mensaje.textContent = "Es ahora, " + marca + " juega.";
  e.target.removeEventListener("click", agregaMarca);
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
          casilla.removeEventListener("click", agregaMarca)
        );
        cruzGanados.push(i);
        buscarGanadorGlobal();
        reiniciarTablero(i, "cruz");
        return;
      }

      if (circuloGana) {
        mensaje.textContent = `¡Círculo gana en el tablero ${i}!`;
        casillasTablero.forEach((casilla) =>
          casilla.removeEventListener("click", agregaMarca)
        );
        circuloGanados.push(i);
        buscarGanadorGlobal();
        reiniciarTablero(i, "círculo");
        return;
      }
    }
  }
}

function reiniciarTablero(targetBoardNum, winner) {
  const targetBoard = document.querySelector(`#t${targetBoardNum}`);
  const shapeElement = document.createElement("div");
  if (winner === "cruz") {
    shapeElement.classList.add("cruzGanadora");
  } else if (winner === "círculo") {
    shapeElement.classList.add("círculoGanador");
  }
  targetBoard.innerHTML = "";
  targetBoard.appendChild(shapeElement);
}

