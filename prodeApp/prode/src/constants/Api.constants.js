export const API_RM = {

    URL:"https://rickandmortyapi.com/api",

    CHARACTERS : function(){
        return `${this.URL}/character`
    },
    CHARACTER_BY_ID : function(id){
        return `${this.URL}/character/${id}`
    },
    LOCATIONS : function(){
        return `${this.URL}/location`
    },
    LOCATION_BY_ID : function(id){
        return `${this.URL}/location/${id}`
    },
    EPISODES : function(){
        return `${this.URL}/episode`
    },
    LOCATION_BY_ID : function(id){
        return `${this.URL}/episode/${id}`
    }
}
/*
export const API_FULBO = {

    const url = 'https://api-football-beta.p.rapidapi.com/fixtures?date=2023-08-23';
    const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': '76460cea6emsha88cb53df3d75e8p13bc1ajsn5c6bdccdbd94',
		'X-RapidAPI-Host': 'api-football-beta.p.rapidapi.com'
	}
};

}

const url = 'https://api-football-beta.p.rapidapi.com/fixtures?date=2023-08-23';
const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': '76460cea6emsha88cb53df3d75e8p13bc1ajsn5c6bdccdbd94',
		'X-RapidAPI-Host': 'api-football-beta.p.rapidapi.com'
	}
};

async function fetchear(){
        let response = await fetch(url,options);
        let data = await response.json();
        return data;
}
const ul = document.getElementById("lista");
async function mostrarLogoLiga(){
    const resultados = await fetchear();
    // console.log(resultados.response[0].teams.away);
    let img = document.createElement("img");
    img.setAttribute("src", resultados.response[3].teams.away.logo);
    img.setAttribute("alt", "Character Image");
    let li = document.createElement("li");
    li.appendChild(img);
    ul.appendChild(li);   
}

async function mostrarEquipos(){
    const data = await fetchear();
    
    const response = data.response;
    
    response.forEach(e => {
        
        if(e.league.name=="Copa de la Liga Profesional"){
            let equipoLocal = document.createElement("p");
            equipoLocal.innerHTML = e.teams.home.name;
            let equipoVisitante = document.createElement("p");
            equipoVisitante.innerHTML = e.teams.away.name;

            let li = document.createElement("li")
            li.appendChild(equipoLocal);
            ul.appendChild(li); 
            li.appendChild(equipoVisitante);
            ul.appendChild(li); 
        }
    });
}
*/
