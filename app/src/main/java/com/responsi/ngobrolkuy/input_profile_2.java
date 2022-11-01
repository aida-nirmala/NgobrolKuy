package com.responsi.ngobrolkuy;

private ImageView ivpinkcircle;
private CircleImageView ivprofilepic;
private static final String TAG = ProfilePicActivity.class.getCanonicalName();
private static final int GALLERY_REQUEST_CODE = 1;
private static String gambarUri = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        ivpinkcircle = findViewById(R.id.pinkCircle);
        ivprofilepic = findViewById(R.id.profilePic);

        ivpinkcircle.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
        }
        });
        }

@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
        Toast.makeText(this, "cancel input image", Toast.LENGTH_SHORT).show();
        return;
        }
        else if (requestCode == GALLERY_REQUEST_CODE){
        if (data != null){
        try {
        Uri ImageUrl =data.getData();
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), ImageUrl);
        ivprofilepic.setImageBitmap(bitmap );
        gambarUri = ImageUrl.toString();
        }
        catch (IOException e){
        Toast.makeText(this, "can't load image", Toast.LENGTH_SHORT).show();
        Log.e(TAG, e.getMessage());
        }
        }
        }
        }