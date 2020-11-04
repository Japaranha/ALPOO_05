import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Departament departament;
	private List<HourContract> contract = new ArrayList();

	public Worker() {

	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContract() {
		return contract;
	}

	public void addContract(HourContract contract) {
		this.contract.add(contract);
	}

	public void removeContract(HourContract contract) {
		this.contract.remove(contract);
	}

	public Double income(Integer month, Integer year) {
		double soma = baseSalary;

		Calendar cal = Calendar.getInstance();
		for (HourContract c : contract) {
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				soma += c.totalValue();
			}
		}
		return soma;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", departament="
				+ departament + ", contract=" + contract + "]";
	}
	

}
