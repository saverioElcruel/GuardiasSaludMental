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