
package nithin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Nithin {
    public static void genImage(String Gender,String Body,String Face,String Head,String Possesion,String CharacterName,String ResultName){
        try {
            int rows = 1;   //we assume the no. of rows and cols are known and each chunk has equal width and height
            int cols = 2;
            int chunks = 4;
            int chunkWidth, chunkHeight;
            String body,face,head,gender,possesion,characterName,resultName;
            int type;
            /*gender="female";
            body="sitting";
            face="happy";
            head="crown";
            possesion="weapon";
            characterName="default";
            resultName="combination";
            //setting location for gender     */
            gender=Gender;
            body=Body;
            face=Face;
            head=Head;
            possesion=Possesion;
            characterName=CharacterName;
            resultName=ResultName;
            String link;
            link="/home/kavin/Documents/git/story material/poses/male";
            if(gender.toLowerCase()=="male"){
                link="/home/kavin/Documents/git/story material/poses/male";
            }
            else if(gender.toLowerCase()=="female"){
                link="/home/kavin/Documents/git/story material/poses/female";
            }   //fetching image files
            File[] imgFiles = new File[chunks];
            //for (int i = 0; i < chunks; i++) {
            imgFiles[0] = new File(link+"/body/"+body+".png");
            System.out.println(imgFiles[0].exists());
            imgFiles[1] = new File(link+"/face/"+face+".png");
            System.out.println(imgFiles[1].exists());
            imgFiles[2] = new File("/home/kavin/Documents/git/story material/poses/head/"+head+".png");
            System.out.println(imgFiles[2].exists());
            imgFiles[3] = new File("/home/kavin/Documents/git/story material/poses/possesion/"+possesion+".png");
            System.out.println(imgFiles[3].exists());
            //}   /home/kavin/Documents/Export/poses/body/
// C:/Users/prem/Desktop
            //creating a bufferd image array from image files
            BufferedImage[] buffImages = new BufferedImage[chunks];
            for (int i = 0; i < chunks; i++) {
                buffImages[i] = ImageIO.read(imgFiles[i]);
            }   type = buffImages[0].getType();
            chunkWidth = buffImages[0].getWidth()+buffImages[3].getWidth();
            chunkHeight = buffImages[0].getHeight()+buffImages[1].getHeight()+20+25;
            System.out.println("The total height is "+buffImages[0].getHeight()+" + "+buffImages[1].getHeight()+" = "+chunkHeight);
            System.out.println("The total width is "+buffImages[0].getWidth()+" + ");
            //Initializing the final image
            BufferedImage finalImg = new BufferedImage(chunkWidth, chunkHeight, type);
            int num = 0;
            //for (int i = 0; i < rows; i++) {
            //    for (int j = 0; j < cols; j++) {
            finalImg.createGraphics().drawImage(buffImages[2], 0, 0+20, null);
            finalImg.createGraphics().drawImage(buffImages[1], 0, 25+20, null);
            finalImg.createGraphics().drawImage(buffImages[0], 0, 25+buffImages[1].getHeight()+20, null);
            finalImg.createGraphics().drawImage(buffImages[3],buffImages[0].getWidth() , 20, null);
            //Color originalColor = new Color(finalImg.getRGB(11, 11), true);
            Graphics g=finalImg.getGraphics();
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            System.out.println(finalImg.createGraphics().getColor());
            g.drawString(characterName, 10, 15);
            //num++;
            //    }
            //}
            System.out.println("Image concatenated.....");
            ImageIO.write(finalImg, "png", new File("/home/kavin/Documents/git/comic/images/"+resultName+".png"));
        } catch (IOException ex) {
            Logger.getLogger(Nithin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws IOException, JSONException{
       //genImage(Gender,Body,Face,onHead,Possesion,CharacterName,ResultName)
       // genImage("male","sitting","sleep","crown","default","Nithin Sanjey","nithin");
        //File fr=new File("StoryChar.json");
        //String str=
        String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("/home/kavin/Documents/git/comic/StoryChar.json"));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
        System.out.println(jsonData);
    
        
            
            JSONArray obj = new JSONArray(jsonData);
            for(int i=0;i<obj.length();i++){
                String mychar=obj.getString(i);
                System.out.println(mychar + " processing");
                String[] segment=mychar.split(" ");
            for (String segment1 : segment) {
                if ("king".equals(segment1)) {
                    genImage("male","standing","default","crown","default",((mychar.replaceAll("\\s","")).split(":"))[0],(mychar.replaceAll("\\s","")));
                    break;
                }else if ("queen".equals(segment1)) {
                    genImage("female","standing","default","crown","default",((mychar.replaceAll("\\s","")).split(":"))[0],(mychar.replaceAll("\\s","")));
                    break;
                } 
                else if ("MALE".equals(segment1)) {
                    genImage("male","standing","default","default","default",((mychar.replaceAll("\\s","")).split(":"))[0],(mychar.replaceAll("\\s","")));
                    break;
                } else if ("FEMALE".equals(segment1)) {
                    genImage("female","standing","default","default","default",((mychar.replaceAll("\\s","")).split(":"))[0],(mychar.replaceAll("\\s","")));
                    break;
                    
                } else if ("UNKNOWN".equals(segment1)) {
                    genImage("male","standing","default","default","default",((mychar.replaceAll("\\s","")).split(":"))[0],(mychar.replaceAll("\\s","")));
                    break;
                
                }
            }
            }
            
            //String name = obj.getString("king rayalu");
        //String url = obj.getString("url");

        //System.out.println(name);
         
        
   }
    
}
