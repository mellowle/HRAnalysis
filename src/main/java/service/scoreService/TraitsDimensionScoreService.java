package service.scoreService;

import com.google.common.collect.Lists;
import entity.dimensionRawData.DTraits;
import entity.dimensionScored.DTraitsScored;
import entity.excelEntity.Traits;
import excelMapping.TraitsColMapping;
import util.KF4DScoreFunctionUtils;
import util.TableUtils;

import java.util.List;

public class TraitsDimensionScoreService extends Score2EntityService {

    public TraitsDimensionScoreService() {
        this.TABLE_NAME_SCORED = TraitsColMapping.TABLE_NAME_SCORED;
        this.CLAZZ = DTraitsScored.class;
    }

    public static void main(String... args) throws Exception {
        TraitsDimensionScoreService c = new TraitsDimensionScoreService();
        List<DTraitsScored> results = c.getScoredResults();
        System.out.println(results.size());
        c.initTable();
        c.insertRecords(results);
    }

    public static List<DTraitsScored> getScoredResults() throws Exception {
        List<DTraitsScored> scoredResults = Lists.newArrayList();

        List<DTraits> dTraitsList = Lists.newArrayList();

        List<Traits> results = TableUtils.getAllRecords(Traits.class);

        results.forEach(traits->{
            DTraits dTraits = new DTraits(traits.getWwid(), traits.getAdaptability(), traits.getAffiliation(), traits.getAssertiveness(),
                    traits.getComposure(), traits.getConfidence(), traits.getCredibility(), traits.getCuriosity(), traits.getEmpathy(),
                    traits.getFocus(), traits.getHumility(), traits.getInfluence(), traits.getNeed_for_achievement(),
                    traits.getOpenness_to_differences(), traits.getOptimism(), traits.getPersistence(), traits.getRisk_taking(),
                    traits.getSituational_self_awareness(), traits.getSociability(), traits.getTolerance_of_ambiguity(),
                    traits.getTrust());
            dTraitsList.add(dTraits);
        });

        for (DTraits dTraits : dTraitsList) {
            DTraitsScored dTraitsScored = new DTraitsScored(dTraits.getWwid(), KF4DScoreFunctionUtils.calcTraitsScore(dTraits.getTraits()));
            scoredResults.add(dTraitsScored);
        }

        return scoredResults;
    }
}
