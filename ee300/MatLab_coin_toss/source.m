%Vincent Chan
%RedID 815909699

%flip those coins fam
result = round(rand(10000,4));

%Step 1: PDF and CDF of sum of heads
rowTotal = sum(result, 2);
numHeads = zeros(5,2);
%This the hand calculated PDF, as explained in the report
numHeads(1,2) = 10000 * (1/16);
numHeads(2,2) = 10000 * (4/16);
numHeads(3,2) = 10000 * (6/16);
numHeads(4,2) = 10000 * (4/16);
numHeads(5,2) = 10000 * (1/16);
for i = 1:length(rowTotal)
    numHeads(rowTotal(i,1) + 1) = numHeads(rowTotal(i,1) + 1) + 1;
end
%This is the CDF
cdfSums = zeros(5,1);
cdfSums(1) = numHeads(1,1)/10000;
for i = 2:5
    cdfSums(i) = cdfSums(i-1) + (numHeads(i,1)/10000);
end

%Step 2: Find run lengths
runTotals = zeros(20,2);
%This will find out the run length of the coins
total = 1;
lastRes = result(1);
for i=2:40000
    if lastRes == result(i)
        total = total + 1;
        if i == 40000
            runTotals(total) = runTotals(total) +1;
        end
    
    else
        if i == 40000
            runTotals(1) = runTotals(1) + 1;
        end
        runTotals(total) = runTotals(total) + 1;
        total = 1;
        lastRes = result(i);
    end
end
%This will calculate the PDF of the estimated PDF
totalRuns = sum(runTotals,1);
for i = 1:20
    runTotals(i,2) = totalRuns(1) * (1/(2.^i));
end
%This will calculate the CDF
cdfRuns = zeros(5,1);
cdfRuns(1) = 1/2;
for i = 2:5
    cdfRuns(i) = cdfRuns(i-1) + (1/(2.^i));
end
    


%Step 3: Plot the figures
%PDF
figure

%Graph 1 - 4 flips, number of heads
subplot(2,1,1);
bar(numHeads);
title('Number of heads in 4 coin flips');
xlabel('Number of Heads');
ylabel('Frequency');
set(gca,'XTickLabel',[0,1,2,3,4]);
legend('Experimental', 'Binominal Distribution');

%Graph 2 - consecutive heads
subplot(2,1,2);
bar(runTotals);
title('Number of consecutive flips (40k trials)');
xlabel('Consecutive flips');
ylabel('Frequency');
legend('Experimental', 'Binominal Distribution');
axis([0,10,0,11000]);

%CDF
figure

    %Graph 3 - CDF of 4 flips
    subplot(2,1,1);
    bar(cdfSums);
    title('Number of heads in 4 coin flips');
    xlabel('Number of Heads');
    ylabel('Total Probability');
    set(gca,'XTickLabel',[0,1,2,3,4]);
    
    %Grpah 4 - CDF of consecutive flips
    subplot(2,1,2);
    bar(cdfRuns);
    title('Number of consecutive flips (40k trials)');
    xlabel('Consecutive flips');
    ylabel('Total Probability');

%The future is here,
%It's just not widely distributed yet.
%William Gibson
