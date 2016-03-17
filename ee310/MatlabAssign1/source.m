%%%%%%%%%%%%Circuit Definition%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%                                                                    %%
%Frequency
w = (2*pi)*130*(10.^6);

%Power Sources
V1rms = 1;
V2rms = 1;
Vr = 0;

%Antenna Resistance
R14 = 50;

%Components
R1 = 15; L1 = 24*(10.^-9);
R2 = 15; L2 = 24*(10.^-9);
C3 = 31.5*(10.^-12);
L4 = 24.2*(10.^-9);
L5 = 24.2*(10.^-9);
C6 = 1*(10.^-20); %DNI
C7 = 22*(10.^-12);
L8 = 56*(10.^-9);
C9 = 44*(10.^-12);
C10 = 4.7*(10.^-12); L10 = 56*(10.^-9);
C11 = 33*(10.^-12);
C12 = 12*(10.^-12); L12 = 39*(10.^-9);
C13 = 16.7*(10.^-12);

%Impedences
Z1 = (R1) + (j*w*L1);
Z2 = (R2) + (j*w*L2);
Z3 = 1/(j*w*C3);
Z4 = j*w*L4;
Z5 = j*w*L5;
Z6 = 1/(j*w*C6);
Z7 = 1/(j*w*C7);
Z8 = j*w*L8;
Z9 = 1/(j*w*C9);
Z10 = ((j*w*L10)*(1/(j*w*C10)))/((j*w*L10)+(1/(j*w*C10))); %L10||C10
Z11 = 1/(j*w*C11);
Z12 = ((j*w*L12)*(1/(j*w*C12)))/((j*w*L12)+(1/(j*w*C12))); %L12||C12
Z13 = 1/(j*w*C13);
Z14 = R14;
%%                                                                    %%
%%%%%%%%%%%%Circuit Definition%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%Calculate Currents%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%                                                                    %%
%Declare matrix

A = [(Z1+Z2+Z3),-Z3,0,0,0,0,0;
      -Z3,(Z3+Z4+Z5+Z6),-Z6,0,0,0,0;
      0,-Z6,(Z6+Z7),-Z7,0,0,0;
      0,0,-Z7,(Z7+Z8+Z9),-Z9,0,0;
      0,0,0,-Z9,(Z9+Z10+Z11),-Z11,0;
      0,0,0,0,-Z11,(Z11+Z12+Z13),-Z13;
      0,0,0,0,0,-Z13,(Z13+Z14)];
V = [V1rms + V2rms;0;0;0;0;0;-Vr];

I = A\V;
%%                                                                    %%
%%%%%%%%%%%%Calculate Currents%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%Find VRMS needed for 80W%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%                                                                    %%
power = .5 * (abs(I(7)).^2) * Z14;
disp(strcat('Power @ 1Vpp = ', num2str(power), ' Watts'));
disp(I(4));
%I ain't got time to calculate power!
while power<80
    V1rms = V1rms+1;
    V2rms = V2rms+1;
    V = [V1rms + V2rms;0;0;0;0;0;-Vr];
    I = A\V;
    power = .5 * (abs(I(7)).^2) * Z14;
end
%got it fam
disp(strcat(                        ...
     num2str(power), ' Watts @ ',   ...
     ' Vrms = ', num2str(V1rms), ' V'));
 disp(real(I(5)*Z10));
%%                                                                    %%
%%%%%%%%%%%%Find VRMS needed for 80W%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
