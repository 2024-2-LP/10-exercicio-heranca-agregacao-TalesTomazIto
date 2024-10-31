package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();
    private String nome;
    private Integer vagas;

    public Consultoria() {
    }

    public Consultoria(List<Desenvolvedor> desenvolvedores, String nome, Integer vagas) {
        this.desenvolvedores = desenvolvedores;
        this.nome = nome;
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double salarioTotal = 0.0;
        for (Desenvolvedor j : desenvolvedores) {
            salarioTotal += j.calcularSalario();
        }

        return salarioTotal;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer qtdDevsMobile = 0;

        for (Desenvolvedor j : desenvolvedores) {
            if (j instanceof DesenvolvedorMobile) {
                qtdDevsMobile++;
            }
        }

        return qtdDevsMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> salariosMaioresQ = new ArrayList<>();

        for (Desenvolvedor j : desenvolvedores) {
            if (j.calcularSalario() >= salario) {
                salariosMaioresQ.add(j);
            }
        }

        return salariosMaioresQ;
    }

    public Desenvolvedor buscarMenorSalario() {
        if(desenvolvedores.isEmpty()) {
            return null;
        }

        Desenvolvedor menorSalario = desenvolvedores.get(0);

        for (Desenvolvedor j : desenvolvedores) {
            if (menorSalario.calcularSalario() > j.calcularSalario()) {
                menorSalario = j;
            }
        }

        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> devsPorTecnologia = new ArrayList<>();

        for (Desenvolvedor j : desenvolvedores) {
            if(j instanceof DesenvolvedorMobile) {
                if(((DesenvolvedorMobile) j).getPlataforma() == tecnologia) {
                    devsPorTecnologia.add(j);
                }
                if(((DesenvolvedorMobile) j).getLinguagem() == tecnologia) {
                    devsPorTecnologia.add(j);
                }
            }
            if (j instanceof DesenvolvedorWeb) {
                if(((DesenvolvedorWeb) j).getFrontend() == tecnologia) {
                    devsPorTecnologia.add(j);
                }
                if(((DesenvolvedorWeb) j).getBackend() == tecnologia) {
                    devsPorTecnologia.add(j);
                }
                if(((DesenvolvedorWeb) j).getSgbd() == tecnologia) {
                    devsPorTecnologia.add(j);
                }
            }
        }
        return devsPorTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double salarioTotalPorTecnologia = 0.0;

        for (Desenvolvedor j : buscarPorTecnologia(tecnologia)) {
            salarioTotalPorTecnologia += j.calcularSalario();
        }

        return salarioTotalPorTecnologia;
    }
}
