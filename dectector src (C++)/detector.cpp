#include<opencv2/opencv.hpp>
#include<opencv/highgui.h>
#include<string>
#include<iostream>
#include <algorithm> 
#include <fstream>
using namespace cv;
using namespace std;


class space {
	public:
	int color[5] = {};//r g b y o
	char theColor = 'D';
	void detect() {
		int temp = 0;
		for (int i = 0; i < 5; i++)
			if (color[i] > color[temp])
				temp = i;
		if (color[temp] >= 750)//��3����1�ŦXH��
		{
			switch (temp) {
				case 0:
					theColor = 'F';
					break;
				case 1:
					theColor = 'R';
					break;
				case 2:
					theColor = 'L';
					break;
				case 3:
					theColor = 'U';
					break;
				case 4:
					theColor = 'B';
					break;
				default:
					break;
			}
		}

	}
};

int main() {
	VideoCapture d(0);
	string output[6] = { "","","","","","" };
	char name[255] = "";
	for (int p = 0; p < 6; p++) {
		Mat src; //��Ϥ�
		Mat hsv; //���hsv����
		Mat r, r2, g, b, y, o, w; //�U�C�⪺�֭�
		//name.push_back('b');
		sprintf_s(name, "test%d.jpg", p);
		src = imread(name);

		//d >> src;
		Mat dst; //���G�Ϥ�

		Mat mask = Mat::zeros(src.rows, src.cols, CV_8U); //���F�o����L�C��

		cvtColor(src, hsv, CV_BGR2HSV);//�নhsv����

		inRange(hsv, Scalar(0, 150, 50), Scalar(8, 255, 255), r);
		//�G�ȤơGh�Ȥ���0~10 & s�Ȥ���100~255 & v�Ȥ���120~255
		inRange(hsv, Scalar(156, 100, 50), Scalar(180, 255, 255), r2);
		//�G�ȤơGh�Ȥ���170~180 & s�Ȥ���100~255 & v�Ȥ���120~255
		inRange(hsv, Scalar(20, 60, 50), Scalar(35, 255, 255), y);
		//�G�ȤơGh�Ȥ���50~70 & s�Ȥ���100~255 & v�Ȥ���120~255
		inRange(hsv, Scalar(90, 40, 50), Scalar(124, 255, 255), b);
		//�G�ȤơGh�Ȥ���110~130 & s�Ȥ���100~255 & v�Ȥ���120~255
		inRange(hsv, Scalar(35, 100, 50), Scalar(90, 255, 255), g);
		//�G�ȤơGh�Ȥ���110~130 & s�Ȥ���100~255 & v�Ȥ���120~255
		inRange(hsv, Scalar(8, 60, 50), Scalar(20, 255, 255), o);
		//�G�ȤơGh�Ȥ���110~130 & s�Ȥ���100~255 & v�Ȥ���120~255
		inRange(hsv, Scalar(0, 0, 231), Scalar(180, 100, 255), w);
		//�G�ȤơGh�Ȥ���110~130 & s�Ȥ���100~255 & v�Ȥ���120~255
		mask = r + r2 + g + o + b + y +w;//�������G�Ȥƹϲ֥[�_�ӴN�ܦ��B�n

		src.copyTo(dst, mask); //�N��Ϥ��g�ѾB�n�L�o��A�o�쵲�Gdst
		float R, G, B;
		float H = 0, S = 0, V = 0;

		//imshow("result", dst);//show���G
		//waitKey(500000);
		space qua[9];
		int k = 0;
		int v = -25;
		int i = 0;
		int j = 95;
		while (k != 9) {
			i = v;
			if (k % 3 == 0)
				i += 130;
			if (j > 485)
				j = 95;
			j += 80;

			v = i;
			int m = j;
			for (; i <= v + 50; i++) {
				for (j = m; j <= m + 50; j++) {
					float ma, mi, x;
					B = dst.at<Vec3b>(i, j)[0];//b
					G = dst.at<Vec3b>(i, j)[1];//g
					R = dst.at<Vec3b>(i, j)[2];//r
					ma = max(B, G);
					ma = max(ma, R);
					mi = min(B, G);
					mi = min(mi, R);
					x = ma - mi;

					V = ma;
					if (ma != 0)
						S = x / ma * 255;


					if (x > 0) {
						if (R == ma) {
							if (G >= B)
								H = (G - B) / (ma - mi) * 60;
							else
								H = (G - B) / (ma - mi) * 60 + 360;
						}
						else if (G == ma)
							H = 120 + (B - R) / (ma - mi) * 60;
						else if (B == ma)
							H = 240 + (R - G) / (ma - mi) * 60;


						H /= 2;

						/*if (p==1&&k==7)
						cout << H << endl;*/
						if (!(S <= 50 && V >= 195))//�P�_�զ�
						{
							if ((H > 0 && H < 8) || (H > 156 && H < 180))
								qua[k].color[0]++;
							else if (H > 35 && H < 80)
								qua[k].color[1]++;
							else if (H > 95 && H < 124)
								qua[k].color[2]++;
							else if (H > 20 && H < 35)
								qua[k].color[3]++;
							else if (H > 8 && H < 20)
								qua[k].color[4]++;
						}
					}
				}
			}

			qua[k].detect();
			//cout << qua[k].theColor << endl;
			k++;
		}

		int n;
		//U�@R F D L B
		if (qua[4].theColor == 'U')
			n = 0;
		else if (qua[4].theColor == 'R')
			n = 1;
		else if (qua[4].theColor == 'F')
			n = 2;
		else if (qua[4].theColor == 'D')
			n = 3;
		else if (qua[4].theColor == 'L')
			n = 4;
		else if (qua[4].theColor == 'B')
			n = 5;
		for (int c = 0; c < 9; c++) {
			output[n].push_back(qua[c].theColor);
			//cout<<qua[c].theColor<<endl;
		}

	}
	ofstream out("cubeFacelet.txt");
	for (int i = 0; i<6; i++)
		for (int j = 0; j<9; j++)
			out.write((char*)&output[i][j], sizeof(output[i][j]));

	out.close();
	//imshow("b", r);//show b
	//imshow("mask", dd);//show mask
	//imshow("src", src);//show��Ϥ�





}