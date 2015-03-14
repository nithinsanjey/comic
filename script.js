$(document).ready(function(){
    var images=["barber","brahmin","guard","king","tenali"];
    var character=[];
    var mapCharacter=[];
    $.getJSON("StoryChar.json",function(json){
        $.each(json,function(){
            character.push(JSON.stringify(this));
            mapCharacter.push("man1.png");
            var subs=this.split(" ");
            for(var i=0;i<subs.length;i++){

                subs[i]=subs[i].toLowerCase();
                //console.log("subs thing "+subs[i]);
            }
            for(var i=0;i<subs.length;i++){
                for(var j=0;j<images.length;j++){
                    console.log(subs[i]==images[j]+" "+subs[i]+" == "+images[j]);
                    if( (subs[i]==images[j]) || (subs[i]==images[j]+"s") ){
                        mapCharacter[(mapCharacter.length-1)]=(images[j]+".png");
                        break;
                    }
                    /*else if(i=(subs.length-1)){
                        mapCharacter.push("man1.png");
                        break;
                    }*/
                }
            }
        });
        console.log(character);
    console.log(mapCharacter);
    });
    //console.log(character);
    //console.log(mapCharacter);

   $("#press").click(function(){
        //$.getJSON("content.json",function(json){
        $.getJSON("Story.json",function(json){
            //var content="<div id='main' class='main'>";
            var bg="";
            var ch1="";
            var ch2="";
            var frame=1;
		$.each(json,function(){
                    var dia1="";
                    var dia2="";
                    //var content='<div id="main" class="main" style="background-image:url(images/'+this['background']+')">';
                    //console.log(this['dialogue'].length);
                    if(this['dialogue'].length==1){
                        dia1=this['dialogue'][0];
                    }
                    else if(this['dialogue'].length==2){
                        dia1=this['dialogue'][0];
                        dia2=this['dialogue'][1];
                    }
                    //alert("hello");
                    var char1="";
                    var char2="";
                    if(this['character'].length==1){
                        console.log("index of character "+character.indexOf('"'+this['character'][0]+'"'));

                        var index=parseInt(character.indexOf('"'+this['character'][0]+'"'));
                        char1=mapCharacter[character.indexOf('"'+this['character'][0]+'"')];
                        console.log("corres image "+mapCharacter[character.indexOf(this['character'][0])]);
                    }
                    if(this['character'].length>1){
                        console.log("index of character "+character.indexOf('"'+this['character'][0]+'"'));

                        var index1=parseInt(character.indexOf('"'+this['character'][0]+'"'));
                        var index2=parseInt(character.indexOf('"'+this['character'][1]+'"'));
                        char1=mapCharacter[character.indexOf('"'+this['character'][0]+'"')];
                        char2=mapCharacter[character.indexOf('"'+this['character'][1]+'"')];
                        console.log(character);
                        console.log("corres image "+mapCharacter[character.indexOf(this['character'][0])]);
                    }
                    var content='<div id="main" class="main" style="background-image:url(images/forest.jpg)">';
                        //alert("Niythhin");
			content=content+'<div id="place1" class="place1" style="background-image:url(images/'+char1+')"><div class="message">Frame '+frame+'<br>'+this['discription']+
                                '</div><div id="message1" class="message"><br>'
                                +dia1+
                                '</div></div>'+
                                '<div id="place2" class="place2" style="background-image:url(images/'+char2+')" >'+
                                '<div id="message1 class="message2"><br><br>'+
                                dia2+'</div></div>';
                        bg=this['background'];
                        ch1=this['character1'];
                        ch2=this['character2'];
                        $("#main1").before(content+"</div><div class='separator'></div>");
                        //$(".place1").css({"background-image": "url('images/"+ch1+"')"});
                        //$(".place2").css({"background-image": "url('images/"+ch2+"')", "background-size":"contain"});
                        //$(".main").css({"background-image": "url('images/"+bg+"')"});
                        frame=frame+1;
                });
                $("#moral").animate({opacity:1});
                $("#press").attr("disabled","true");                     
        });    
        }); // press click function ends
        var s=$(".main");
        var n=-1;var node=0;
        $(document).keypress(function(e){
            if(e.keyCode === 40){
            node=s[++n];
            $.ScrollTo()
            }
        });//keypress function ends
});