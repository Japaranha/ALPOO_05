import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
		Scanner sc =new Scanner(System.in);
		
		System.out.print("Enter departament's name: ");
		String nameDepartament = sc.next();
		Departament departament = new Departament(nameDepartament);
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Level: ");
		String level = sc.next();
		WorkerLevel levelMario = WorkerLevel.valueOf(level);
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, levelMario, baseSalary, departament);
		System.out.print("How many contracts to this worker? ");
		int rep = sc.nextInt();
		for(int i =1; i<=rep;i++) {
			System.out.println("Enter contract #" + i +" data");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
	
			int ano = Integer.parseInt(sdf2.format(contractDate));
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate,valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.print("Enter month and year to calvulate income (MM/YYYY): ");
		Date dataescolha = sdf3.parse(sc.next());
		int mes = Integer.parseInt(sdf1.format(dataescolha));
		int ano = Integer.parseInt(sdf2.format(dataescolha));
		worker.income(mes, ano);
		System.out.println(worker);
		System.out.println("name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income: " + worker.income(mes,ano));
		
	}

}
