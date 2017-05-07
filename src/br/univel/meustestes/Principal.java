package br.univel.meustestes;

import java.math.BigDecimal;

import br.univel.minhaarvore.UniArvore;
import br.univel.minhaarvore.UniArvoreImpl;
import br.univel.minhaarvore.UniNode;
import br.univel.minhaarvore.UniNodeImpl;

public class Principal {

	public Principal() {		
			
		Conta contaAgua = new Conta(1, "Água", new BigDecimal("101.28"));		
		UniNode<Conta> noAgua = new UniNodeImpl<>(contaAgua);		
		
		Conta contaAluguel = new Conta(1, "Aluguel", new BigDecimal("900.00"));
		UniNode<Conta> noAlu = new UniNodeImpl<>(contaAluguel);
		
		Conta contaIntTel = new Conta(1, "Internet e Telefone", new BigDecimal("165.35"));
		UniNode<Conta> noIntTel = new UniNodeImpl<>(contaIntTel);
		
		Conta contaEnElet = new Conta(1, "Energia Elétrica", new BigDecimal("252.58"));
		UniNode<Conta> noEnElet = new UniNodeImpl<>(contaEnElet);		
		
		
		Conta despesasAdm = new Conta(1, "Despesas Administrativas", new BigDecimal(0));
		UniNode<Conta> noDeAdm = new UniNodeImpl<>(despesasAdm);
		noDeAdm.addFilho(noAgua);
		noDeAdm.addFilho(noAlu);
		noDeAdm.addFilho(noIntTel);
		noDeAdm.addFilho(noEnElet);		
	
		
		Conta contaBenef = new Conta(1, "Benefícios", new BigDecimal("169.43"));
		UniNode<Conta> noBenef = new UniNodeImpl<>(contaBenef);
		
		Conta contaEnc = new Conta(1, "Encargos", new BigDecimal("331.25"));
		UniNode<Conta> noEnc = new UniNodeImpl<>(contaEnc);
		
		Conta contaSal = new Conta(1, "Salários", new BigDecimal("116.13"));
		UniNode<Conta> noSal = new UniNodeImpl<>(contaSal);
		
		Conta gastoPes = new Conta(1, "Gastos com Pessoal", new BigDecimal(0));
		UniNode<Conta> noDeGastoPes = new UniNodeImpl<>(gastoPes);
		noDeGastoPes.addFilho(noBenef);
		noDeGastoPes.addFilho(noEnc);
		noDeGastoPes.addFilho(noSal);				
		
		
		Conta servLimp = new Conta(1, "Serviços de Limpeza", new BigDecimal("955.43"));
		UniNode<Conta> noServLimp = new UniNodeImpl<>(servLimp);
		
		Conta servManut = new Conta(1, "Serviços Manutenção", new BigDecimal("1200.35"));
		UniNode<Conta> noSerManut = new UniNodeImpl<>(servManut);
		
		Conta manutLimp = new Conta(3, "Manutenção e Limpeza", new BigDecimal(0));
		UniNode<Conta> noServManut = new UniNodeImpl<>(manutLimp);
		noServManut.addFilho(noServLimp);
		noServManut.addFilho(noSerManut);		
		
		
		Conta matEscr = new Conta(1, "Materiais Escritório", new BigDecimal("532.66"));
		UniNode<Conta> noMatEsc = new UniNodeImpl(matEscr);
		
		Conta matLimp = new Conta(1, "Materiais de Limpeza", new BigDecimal("331.41"));
		UniNode<Conta> noMatLimp = new UniNodeImpl(matLimp);
		
		Conta mater = new Conta(4, "Materiais", new BigDecimal(0));
		UniNode<Conta> noMaterial = new UniNodeImpl<>(mater);
		noMaterial.addFilho(noMatEsc);
		noMaterial.addFilho(noMatLimp);	
		
		Conta despesasOper = new Conta(1, "Despesas Operacionais", new BigDecimal(0));
		UniNode<Conta> noDeOpr = new UniNodeImpl<>(despesasOper);
		noDeOpr.addFilho(noDeAdm);
		noDeOpr.addFilho(noDeGastoPes);
		noDeOpr.addFilho(noServManut);
		noDeOpr.addFilho(noMaterial);	
		
		UniArvore<Conta> planoContas = new UniArvoreImpl(noDeOpr);		
		
		planoContas.mostrarTodosConsole();
		somarFilhos(planoContas);
		
		
		
		BigDecimal d1 = new BigDecimal("101.28");
		BigDecimal d2 = new BigDecimal("900");
		BigDecimal d3 = new BigDecimal("165.35");
		BigDecimal d4 = new BigDecimal("252.58");		
		d4 = d1.add(d2.add(d3).add(d4));
		
		BigDecimal d5 = new BigDecimal("169.43");
		BigDecimal d6 = new BigDecimal("331.25");
		BigDecimal d7 = new BigDecimal("116.13");				
		d5 = d5.add(d6.add(d7));
		
		BigDecimal d8 = new BigDecimal("955.43");
		BigDecimal d9 = new BigDecimal("1200.35");					
		d8 = d8.add(d9);
		
		BigDecimal d10 = new BigDecimal("532.66");
		BigDecimal d11 = new BigDecimal("331.41");					
		d10 = d10.add(d11);
		
		BigDecimal soma = d4.add(d5.add(d8).add(d10));
		
		System.out.println(" 0" + despesasOper.getId() + " \t\t"+ despesasOper.getNome() + "\t\t\t "+ soma);
		
		System.out.println("   0" + despesasAdm.getId() + ".01 \t  "+ despesasAdm.getNome() + "\t "+ d4);			
		System.out.println("     0" + contaAgua.getId() + ".01.01 \t    "+ contaAgua.getNome() + "\t\t "+ contaAgua.getValor());
		System.out.println("     0" + contaAluguel.getId() + ".01.02 \t    "+ contaAluguel.getNome() + "\t\t "+ contaAluguel.getValor());
		System.out.println("     0" + contaIntTel.getId() + ".01.03 \t    "+ contaIntTel.getNome() + "\t "+ contaIntTel.getValor());
		System.out.println("     0" + contaEnElet.getId() + ".01.04 \t    "+ contaEnElet.getNome() + "\t "+ contaEnElet.getValor());

		System.out.println("   0" + gastoPes.getId() + ".02 \t  "+ gastoPes.getNome() + "\t\t "+ d5);		
		System.out.println("     0" + contaBenef.getId() + ".02.01 \t    "+ contaBenef.getNome() + "\t\t "+ contaBenef.getValor());
		System.out.println("     0" + contaEnc.getId() + ".02.02 \t    "+ contaEnc.getNome() + "\t\t "+ contaEnc.getValor());
		System.out.println("     0" + contaSal.getId() + ".02.03 \t    "+ contaSal.getNome() + "\t\t "+ contaSal.getValor());
		
		System.out.println("   0" + manutLimp.getId() + ".03 \t  "+ manutLimp.getNome() + "\t\t "+ d8);	
		System.out.println("     0" + servLimp.getId() + ".03.01 \t    "+ servLimp.getNome() + "\t "+ servLimp.getValor());
		System.out.println("     0" + servManut.getId() + ".03.02 \t    "+ servManut.getNome() + "  "+ servManut.getValor());
		
		System.out.println("   0" + mater.getId() + ".04 \t  "+ mater.getNome() + "\t\t\t "+ d10);	
		System.out.println("     0" + matEscr.getId() + ".04.01 \t    "+ matEscr.getNome() + " "+ matEscr.getValor());
		System.out.println("     0" + matLimp.getId() + ".04.02 \t    "+ matLimp.getNome() + " "+ matLimp.getValor());
		
		
		
		
		
	}
	
	
	private void somarFilhos(UniArvore<Conta> planoContas) {
		
		
	}

	public static void main(String[] args) {		
		new Principal();
		
	}
	
}
