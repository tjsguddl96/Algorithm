-- 코드를 작성해주세요
select a.id as ID,a.genotype as GENOTYPE, b.genotype as PARENT_GENOTYPE
from ecoli_data as a left join ecoli_data as b on a.parent_id=b.id
where (a.genotype & b.genotype) = b.genotype
order by ID;

