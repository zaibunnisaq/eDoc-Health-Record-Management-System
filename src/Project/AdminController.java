package Project;

public class AdminController 
{
	public void navigateToRegisterDoctor() 
	{
        new RegisterDoc().setVisible(true);
    }

    public void navigateToViewPatient() 
    {
        new ViewPatient().setVisible(true);
    }

    public void logout() 
    {
        new JFrame1().setVisible(true);
    }
}

