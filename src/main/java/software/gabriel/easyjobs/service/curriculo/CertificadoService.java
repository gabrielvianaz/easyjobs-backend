/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.curriculo;

import java.util.List;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.dto.curriculo.CertificadoDTO;
import software.gabriel.easyjobs.entity.curriculo.Certificado;
import software.gabriel.easyjobs.entity.curriculo.Curriculo;
import software.gabriel.easyjobs.repository.curriculo.CertificadoRepository;
import software.gabriel.easyjobs.service.base.curriculo.AbstractCampoCurriculoManyToOneService;

/**
 *
 * @author gabriel
 */
@Service
public class CertificadoService
        extends AbstractCampoCurriculoManyToOneService<Certificado, CertificadoDTO, CertificadoRepository> {

    public CertificadoService() {
        super(Certificado.class);
    }

    public void cadastrar(List<CertificadoDTO> certificadosDTO) {
        Curriculo curriculo = getCurriculoCandidatoAutenticado();
        cadastrar(certificadosDTO, curriculo, curriculo.getCertificados());
    }

    @Override
    protected Certificado aplicarDTO(Certificado certificado, CertificadoDTO certificadoDTO) {
        certificado.setTitulo(certificadoDTO.getTitulo());
        certificado.setInstituicao(certificadoDTO.getInstituicao());
        certificado.setMesEmissao(certificadoDTO.getMesEmissao());
        certificado.setAnoEmissao(certificadoDTO.getAnoEmissao());
        certificado.setUrl(certificadoDTO.getUrl());
        return certificado;
    }

}
