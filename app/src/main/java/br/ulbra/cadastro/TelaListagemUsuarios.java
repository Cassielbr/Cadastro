package br.ulbra.cadastro;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;

public class TelaListagemUsuarios {
    private MainActivity act;
    private Button btAnterior, btProximo, btFechar;
    private TextView txtNome, txtTelefone, txtEndereco, txtStatus; // Adicionado txtStatus
    private int index;

    public TelaListagemUsuarios(MainActivity act) {
        this.act = act;
        this.index = 0;
    }

    public void carregarTela() {
        if (act.getRegistros().isEmpty()) {
            new AlertDialog.Builder(act)
                    .setTitle("Aviso")
                    .setMessage("Não existe nenhum registro cadastrado.")
                    .setNeutralButton("OK", null)
                    .show();
            return;
        }

        act.setContentView(R.layout.listagem_usuarios_cadastrados);
        btAnterior = act.findViewById(R.id.btanterior);
        btProximo = act.findViewById(R.id.btproximo);
        btFechar = act.findViewById(R.id.btfechar);
        txtNome = act.findViewById(R.id.txtnome);
        txtEndereco = act.findViewById(R.id.txtendereco);
        txtTelefone = act.findViewById(R.id.txttelefone);
        txtStatus = act.findViewById(R.id.txtstatus); // Inicializando txtStatus

        preencheCampos(index);
        atualizarStatus(); // Atualiza o status ao carregar a tela

        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;
                    preencheCampos(index);
                    atualizarStatus(); // Atualiza o status ao navegar
                }
            }
        });

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < act.getRegistros().size() - 1) {
                    index++;
                    preencheCampos(index);
                    atualizarStatus(); // Atualiza o status ao navegar
                }
            }
        });

        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act.carregarTelaPrincipal(); // Navega de volta para a tela principal
            }
        });
    }

    private void preencheCampos(int idx) {
        if (idx >= 0 && idx < act.getRegistros().size()) { // Verificação de limites
            txtNome.setText(act.getRegistros().get(idx).getNome());
            txtTelefone.setText(act.getRegistros().get(idx).getTelefone());
            txtEndereco.setText(act.getRegistros().get(idx).getEndereco());
        }
    }

    private void atualizarStatus() {
        int totalRegistros = act.getRegistros().size();
        txtStatus.setText("Registros: " + (index + 1) + "/" + totalRegistros);
    }
}
