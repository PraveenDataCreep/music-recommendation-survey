function updatePlayer(e){
    var songId = e;
    var baseUrl = "https://open.spotify.com/embed/track/";
    var finalUrl = baseUrl + songId;
    console.log("reloading player for song_id: " + finalUrl);
    document.getElementById("player").setAttribute("src", finalUrl);
    if(document.getElementById("selected-song") != null){
        document.getElementById("selected-song").setAttribute("value", e);
    }
    document.getElementById("action-button").disabled=false;
    document.getElementById("player").hidden=false;
}

function generateRecommendations(){
    document.getElementById("recommendation-collector").submit();
}

function saveResponse(){
    var recom_list= document.getElementsByClassName("recoms");
    var response = {};
    var i = 0;
    for(i=0; i<recom_list.length; i++){
        var id = recom_list[i].getAttribute("value");
        var liked = recom_list[i].checked;
        response[id] = liked;
    }
    var response_json = JSON.stringify(response);

    console.log(response_json);

    var response_field = document.getElementById("jsonResponse");
    response_field.setAttribute("value", response_json);
    var response_form = document.getElementById("response-collector");
    response_form.submit();

}