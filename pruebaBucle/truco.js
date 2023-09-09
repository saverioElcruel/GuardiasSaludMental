const numeros = [1,2,3,4,5,6,7,10,11,12];

const palos = ["basto","copa","espada","oro"];

const naipes = [];

for (let i = 0; i < numeros.length; i++) {
    for (let j = 0; j < palos.length; j++) {
        naipes.push(numeros[i]+" "+palos[j])
    }
}
console.log(naipes);

