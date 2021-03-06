import java.util.*;
import java.io.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(new File("open-1.dat"));

        while(true)
        {
            ArrayList<Project> projects = new ArrayList<>();
            HashMap<String, Project> allMembers = new HashMap<>();  //<member, project>
            boolean finished = false;

            while(true)
            {
                String input = in.nextLine();
                if(input.equals("1"))
                {
                    break;
                }
                if(input.equals("0"))
                {
                    finished = true;
                    break;
                }
                if(Character.isUpperCase(input.charAt(0)))
                {
                    projects.add(new Project(input));
                }
                if(Character.isLowerCase(input.charAt(0)))
                {
                    if(allMembers.containsKey(input) && !projects.get(projects.size()-1).members.contains(input)) //!allMembers.get(input).equals(projects.get(projects.size()-1))
                    {
                        allMembers.get(input).members.remove(input);
                        allMembers.put(input, new Project("666"));
                    }
                    else if(!projects.get(projects.size()-1).members.contains(input))
                    {
                        projects.get(projects.size()-1).members.add(input);
                        allMembers.put(input, projects.get(projects.size()-1));
                    }
                }
            }
            if(!finished)
            {
                Collections.sort(projects);
                for(Project project : projects)
                    System.out.println(project);
                System.out.println();
            }
            else
            {
                break;
            }
        }
    }


}
