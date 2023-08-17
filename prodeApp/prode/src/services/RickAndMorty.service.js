
import { API_RM } from './../constants/Api.constants';

class RickAndMortyService {


    async getAllCharacters(){
        const response = await fetch(API_RM.CHARACTERS());
        // Interceptor
        return response.json();
    }
    async getCharacterById(id){
        const response = await fetch(API_RM.CHARACTER_BY_ID(id));
        // Interceptor
        return response.json();
    }
    async getAllLocations(){
        const response = await fetch(API_RM.LOCATIONS());
        // Interceptor
        return response.json();
    }
    async getLocationById(id){
        const response = await fetch(API_RM.LOCATION_BY_ID(id));
        // Interceptor
        return response.json();
    }
    async getAllEpisodes(){
        const response = await fetch(API_RM.EPISODES());
        // Interceptor
        return response.json();
    }
    async getEpisodeById(id){
        const response = await fetch(API_RM.EPISODE_BY_ID(id));
        // Interceptor
        return response.json();
    }

}

export default new RickAndMortyService();