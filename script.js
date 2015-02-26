$(document).ready(function(){

   $("#press").click(function(){
        //$.getJSON("content.json",function(json){
        $.getJSON("content.json",function(json){
            //var content="<div id='main' class='main'>";
            var bg="";
            var ch1="";
            var ch2="";
		$.each(json,function(){
                    var content='<div id="main" class="main" style="background-image:url(images/'+this['background']+')">';
                        //alert("Niythhin");
			content=content+'<div id="place1" class="place1" style="background-image:url(images/'+this['character1']+')">'+this['description']+
                                '<div id="message1" class="message"><br>'
                                +this['dialogue1']+
                                '</div></div>'+
                                '<div id="place2" class="place2" style="background-image:url(images/'+this['character2']+')" >'+
                                '<div id="message1 class="message2"><br><br>'+
                                this['dialogue2']+'</div></div>';
                        bg=this['background'];
                        ch1=this['character1'];
                        ch2=this['character2'];
                        $("#main1").before(content+"</div><div class='separator'></div>");
                        //$(".place1").css({"background-image": "url('images/"+ch1+"')"});
                        //$(".place2").css({"background-image": "url('images/"+ch2+"')", "background-size":"contain"});
                        //$(".main").css({"background-image": "url('images/"+bg+"')"});
                        
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